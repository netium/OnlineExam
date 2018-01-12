package com.tiantianchiji.onlineexam.repositories;

import com.tiantianchiji.onlineexam.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndUserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value="select user from users user where user.username = :username")
    List<UserEntity> findByUsername(@Param("username") String username);

    @Query(value="select user from users user where user.token = :token")
    List<UserEntity> findByToken(@Param("token") String token);
}
