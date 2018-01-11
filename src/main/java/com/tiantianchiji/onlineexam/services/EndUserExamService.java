package com.tiantianchiji.onlineexam.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiantianchiji.onlineexam.dtos.Answer;
import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.entities.ExamInstanceEntity;
import com.tiantianchiji.onlineexam.entities.QuestionEntity;
import com.tiantianchiji.onlineexam.entities.UserEntity;
import com.tiantianchiji.onlineexam.repositories.EndUserExamInstanceRepository;
import com.tiantianchiji.onlineexam.repositories.EndUserExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EndUserExamService {
    @Autowired
    EndUserExamRepository examRepository;

    @Autowired
    EndUserExamInstanceRepository examInstanceRepository;

    @Autowired
    QuestionsService questionsService;

    @Autowired
    EndUserService endUserService;

    public List<ExamEntity> getAllApplicableExams(String userToken) {
        UserEntity user = endUserService.getUserProfile(userToken);
        return examRepository.findAll();
    }

    public List<ExamInstanceEntity> getAllExamInstances(String userToken) {
        UserEntity user = endUserService.getUserProfile(userToken);
        List<ExamInstanceEntity> examInstances = examInstanceRepository.findByUser(user);
        return examInstances;
    }

    public long createNewExamInstance(String userToken, long examId) {
        UserEntity user = endUserService.getUserProfile(userToken);
        if (user == null)
            return -1;

        ExamEntity exam = examRepository.findOne(examId);
        if (exam.getStatus() != 5) {
            return -1;
        }

        if (user.getLevel() < exam.getLevel()) {
            return -1;
        }

        ExamInstanceEntity instance = new ExamInstanceEntity();
        instance.setExam(exam);
        instance.setUser(user);
        instance.setStatus(0);
        instance.setStartTime(new Date());

        instance = examInstanceRepository.save(instance);
        return instance.getId();
    }

    public List<QuestionEntity> getQuestionsForExamInstance(String userToken, long examInstanceId) {
        UserEntity userEntity = endUserService.getUserProfile(userToken);

        ExamInstanceEntity instance = examInstanceRepository.findOne(examInstanceId);
        if (instance == null)
            return null;

        if (userEntity.getId() != instance.getUser().getId())
            return null;

        ExamEntity examEntity = instance.getExam();

        List<QuestionEntity> questions = questionsService.getQuestionsForExam(examEntity);
        return questions;
    }

    public int submitExam(String userToken, long examInstanceId, Answer[] anwers) {
        UserEntity userEntity = endUserService.getUserProfile(userToken);
        if (userEntity == null)
            return -1;

        ExamInstanceEntity instance = examInstanceRepository.findOne(examInstanceId);
        if (instance == null)
            return -2;

        if (instance.getUser().getId() != userEntity.getId())
            return -3;

        if (instance.getStatus() != 0)
            return -4;

        ExamEntity examEntity = instance.getExam();

        List<QuestionEntity> questions = questionsService.getQuestionsForExam(examEntity);

        int totalScore = 0;
        Queue<QuestionEntity> questionsQueue = new ArrayDeque<QuestionEntity>();
        questionsQueue.addAll(questions);
        while (questionsQueue.size() != 0) {
            QuestionEntity entity = questionsQueue.poll();
            for (Answer answer : anwers) {
                if (entity.getId() == answer.getId() && entity.getAnswer().equals(answer.getAnswer())) {
                    totalScore += entity.getPoints();
                }
            }
        }

        instance.setScore(totalScore);
        instance.setStatus(1);
        instance.setSubmitTime(new Date());

        ObjectMapper mapper = new ObjectMapper();
        try {
            String answersJsonString = mapper.writeValueAsString(anwers);
            instance.setAnswers(answersJsonString);
        } catch (JsonProcessingException e) {
            instance.setAnswers("");
        }
        examInstanceRepository.save(instance);

        return 0;
    }
}
