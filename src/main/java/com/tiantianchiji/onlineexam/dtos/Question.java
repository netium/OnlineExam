package com.tiantianchiji.onlineexam.dtos;

import java.util.HashMap;

public class Question {
    private long _id;
    private String _question;
    private int _score;
    private HashMap<Long, String> _options;

    public Question() {

    }

    public Question(long id, String question, int score, HashMap<Long, String> options) {
        _id = id;
        _question = question;
        _score = score;
        _options = options;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getQuestion() {
        return _question;
    }

    public void setQuestion(String question) {
        _question = question;
    }

    public int getScore() {
        return _score;
    }

    public void setScore(int score) {
        _score = score;
    }

    public HashMap<Long, String> getOptions() {
        return _options;
    }

    public void setOptions(HashMap<Long, String> options) {
        _options = options;
    }
}
