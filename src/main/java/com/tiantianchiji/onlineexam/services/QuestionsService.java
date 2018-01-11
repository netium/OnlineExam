package com.tiantianchiji.onlineexam.services;

import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.entities.QuestionEntity;
import com.tiantianchiji.onlineexam.repositories.EndUserExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    @Autowired
    private EndUserExamQuestionRepository questionRepository;

    List<QuestionEntity> getQuestionsForExam(ExamEntity exam) {
        List<QuestionEntity> questions = questionRepository.findByExam(exam);
        return questions;
    }
}
