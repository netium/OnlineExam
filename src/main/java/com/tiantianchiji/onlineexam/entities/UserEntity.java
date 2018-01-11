package com.tiantianchiji.onlineexam.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "endusers")
public class UserEntity implements Serializable {
    private static final long _serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "token")
    private String token;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "level")
    private int level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
