package com.tiantianchiji.onlineexam.repositories;

import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EndUserExamQuestionRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> findByExam(ExamEntity exam);
}
