package com.tiantianchiji.onlineexam.dtos;

import java.util.ArrayList;

public class Exam {
    private ExamInfo _examInfo;
    private ArrayList<Question> _questions;

    public Exam() {

    }

    public Exam(ExamInfo examInfo, ArrayList<Question> questions) {
        _examInfo = examInfo;
        _questions = questions;
    }

    public ExamInfo getExamInfo() {
        return _examInfo;
    }

    public void setExamInfo(ExamInfo examInfo) {
        _examInfo = examInfo;
    }

    public ArrayList<Question> getQuestions() {
        return _questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        _questions = questions;
    }
}
