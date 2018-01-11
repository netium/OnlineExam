package com.tiantianchiji.onlineexam.dtos;

public class ExamInfo {
    private long _id;
    private String _title;
    private String _description;
    private String _author;
    private int _numOfItems;
    private int _passScore;
    private int _totalScore;
    private int _level;

    public ExamInfo() {

    }

    public ExamInfo(long id, String title, String description, String author, int numOfItems, int passScore, int totalScore, int level) {
        _id = id;
        _title = title;
        _description = description;
        _author = author;
        _numOfItems = numOfItems;
        _passScore = passScore;
        _totalScore = totalScore;
        _level = level;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public int getNumOfItems() {
        return _numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        _numOfItems = numOfItems;
    }

    public int getPassScore() {
        return _passScore;
    }

    public void setPassScore(int passScore) {
        _passScore = passScore;
    }

    public int getTotalScore() {
        return _totalScore;
    }

    public void setTotalScore(int totalScore) {
        _totalScore = totalScore;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int level) {
        _level = level;
    }
}
