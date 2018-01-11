package com.tiantianchiji.onlineexam.repositories;

import com.tiantianchiji.onlineexam.entities.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserExamRepository extends JpaRepository<ExamEntity, Long> {
}
