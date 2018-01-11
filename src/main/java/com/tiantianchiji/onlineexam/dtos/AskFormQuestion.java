package com.tiantianchiji.onlineexam.dtos;

import com.tiantianchiji.onlineexam.entities.QuestionEntity;

import java.io.Serializable;

public class AskFormQuestion implements Serializable{
    private static final long serialVersionUID = 1L;

    private long id;
    private String content;
    private int type;
    private int points;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static AskFormQuestion fromEntity(QuestionEntity entity) {
        AskFormQuestion question = new AskFormQuestion();
        question.setId(entity.getId());
        question.setContent(entity.getContent());
        question.setType(entity.getType());
        question.setPoints(entity.getPoints());

        return question;
    }
}
