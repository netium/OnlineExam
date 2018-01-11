package com.tiantianchiji.onlineexam.entities;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Entity(name="exams")
@Table(name="exams")
public class ExamEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn (name = "creator")
    private TeacherEntity creator;

    @Column(name = "creationtime")
    private Date creationTime;

    @Column(name = "passscore")
    private int passScore;

    @Column(name = "status")
    private int status;

    @Column(name = "level")
    private int level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TeacherEntity getCreator() {
        return creator;
    }

    public void setCreatorId(TeacherEntity teacher) {
        this.creator = teacher;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }
}
