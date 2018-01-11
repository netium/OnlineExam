package com.tiantianchiji.onlineexam.repositories;

import com.tiantianchiji.onlineexam.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndUserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUsername(String username);

    List<UserEntity> findByToken(String token);
}
