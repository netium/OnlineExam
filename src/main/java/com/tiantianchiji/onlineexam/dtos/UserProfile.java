package com.tiantianchiji.onlineexam.dtos;

import com.tiantianchiji.onlineexam.entities.UserEntity;

public class UserProfile {
    private long _id;
    private String _username;
    private int _level;

    public UserProfile() {}

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int level) {
        _level = level;
    }

    public static UserProfile fromEntity(UserEntity userEntity) {
        UserProfile profile = new UserProfile();
        profile.setId(userEntity.getId());
        profile.setUsername(userEntity.getUsername());
        profile.setLevel(userEntity.getLevel());

        return profile;
    }
}
