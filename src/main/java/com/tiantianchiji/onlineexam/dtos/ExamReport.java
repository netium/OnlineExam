package com.tiantianchiji.onlineexam.dtos;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ExamReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String description;
    private Date takenTime;
    private String duration;
    private int passScore;
    private int score;
    private boolean isPassed;

    private List<QuestionFeedback> questionFeedback;

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

    public Date getTakenTime() {
        return takenTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTakenTime(Date takenTime) {
        this.takenTime = takenTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<QuestionFeedback> getQuestionFeedback() {
        return questionFeedback;
    }

    public void setQuestionFeedback(List<QuestionFeedback> questionFeedback) {
        this.questionFeedback = questionFeedback;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }
}
