package com.tiantianchiji.onlineexam.repositories;

import com.tiantianchiji.onlineexam.entities.ExamInstanceEntity;
import com.tiantianchiji.onlineexam.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndUserExamInstanceRepository extends JpaRepository<ExamInstanceEntity, Long> {
    List<ExamInstanceEntity> findByUser(UserEntity user);
}
