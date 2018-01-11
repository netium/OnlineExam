package com.tiantianchiji.onlineexam.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="questions")
@Table(name="questions")
public class QuestionEntity implements Serializable {
    private static final long _serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "examid")
    private ExamEntity exam;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private int type;

    @Column(name = "answer")
    private String answer;

    @Column(name = "points")
    private int points;

    @Column(name = "feedback")
    private String feedback;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
