package com.tiantianchiji.onlineexam.services;

import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.entities.ExamInstanceEntity;
import com.tiantianchiji.onlineexam.entities.UserEntity;
import com.tiantianchiji.onlineexam.repositories.EndUserExamInstanceRepository;
import com.tiantianchiji.onlineexam.repositories.EndUserExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EndUserExamService {
    @Autowired
    EndUserExamRepository examRepository;

    @Autowired
    EndUserExamInstanceRepository examInstanceRepository;

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
        if (exam.getStatus() != 0) {
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
}
