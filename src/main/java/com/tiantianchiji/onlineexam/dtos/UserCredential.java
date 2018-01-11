package com.tiantianchiji.onlineexam.dtos;

import java.io.Serializable;

public class UserCredential implements Serializable {
    private static final long _serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
