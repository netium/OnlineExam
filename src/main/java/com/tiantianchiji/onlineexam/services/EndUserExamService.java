package com.tiantianchiji.onlineexam.services;

import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.entities.UserEntity;
import com.tiantianchiji.onlineexam.repositories.EndUserExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndUserExamService {
    @Autowired
    EndUserExamRepository repository;

    @Autowired
    EndUserService endUserService;

    public List<ExamEntity> getAllApplicableExams(String userToken) {
        UserEntity user = endUserService.getUserProfile(userToken);
        return repository.findAll();

    }
}
