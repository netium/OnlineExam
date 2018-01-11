package com.tiantianchiji.onlineexam.services;

import com.tiantianchiji.onlineexam.entities.UserEntity;
import com.tiantianchiji.onlineexam.repositories.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.security.*;
import java.math.*;
import java.util.UUID;

@Service
public class EndUserService {
    private static final Logger _log = LoggerFactory.getLogger(EndUserService.class);

    @Autowired
    EndUserRepository _repository;

    public long createUser(String username, String password) {
        List<UserEntity> users = _repository.findByUsername(username);
        if (users.size() > 0) {
            return -1;
        }
        else {
            String hashedPassword = hashPassword(password);
            if ("".equals(hashedPassword)) {
                return -1;
            }
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            newUser.setLevel(0);
            newUser.setPassword(hashedPassword);
            newUser = _repository.save(newUser);
            return newUser.getId();
        }
    }

    public void updateUser(UserEntity user) {
    }

    public void deleteUser(String currentUserToken, long id) {
        UserEntity user = getUserByToken(currentUserToken);
        if (user == null)
            return;
        if (user.getId() != id)
            return;
        _repository.delete(id);
    }

    public UserEntity getUserProfile(String currentUserToken) {
        UserEntity user = getUserByToken(currentUserToken);
        return user;
    }

    public UserEntity getUserProfile(String currentUserToken, long id) {
        UserEntity user = getUserByToken(currentUserToken);
        if (user == null)
            return null;
        if (user.getId() != id)
            return null;
        return user;
    }

    public String login(String username, String password) {
        List<UserEntity> users = _repository.findByUsername(username);
        if (users.size() == 0)
            return "";
        else {
            String hashedPassword = hashPassword(password);
            if (users.get(0).getPassword().equals(hashedPassword)) {
                UserEntity user = users.get(0);
                user.setToken(generateToken());
                user = _repository.save(user);
                return user.getToken();
            }
            return "";
        }
    }

    public void logout(String currentUserToken) {
        List<UserEntity> users = _repository.findByToken(currentUserToken);
        if (users.size() > 0) {
            UserEntity user = users.get(0);
            user.setToken("");
            _repository.save(user);
        }
    }

    private UserEntity getUserByToken(String userToken) {
        List<UserEntity> users = _repository.findByToken(userToken);
        if (users.size() == 0)
            return null;
        else
            return users.get(0);
    }


    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] data = password.getBytes();
            md.update(data, 0, data.length);
            BigInteger i = new BigInteger(1, md.digest());
            return String.format("%1$032X", i);
        }
        catch (NoSuchAlgorithmException e) {
            _log.error(e.getStackTrace().toString());
        }
        return "";
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
