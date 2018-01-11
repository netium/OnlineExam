package com.tiantianchiji.onlineexam.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "examInstances")
@Table(name = "examinstances")
public class ExamInstanceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "enduserid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "examid")
    private ExamEntity exam;

    @Column(name = "starttime")
    private Date startTime;

    @Column(name = "endtime")
    private Date submitTime;

    @Column(name = "status")
    private int  status;

    @Column(name = "score")
    private int  score;

    @Column(name = "answers")
    private String answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime() {
        this.submitTime = submitTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
