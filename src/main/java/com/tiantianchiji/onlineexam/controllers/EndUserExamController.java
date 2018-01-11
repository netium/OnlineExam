package com.tiantianchiji.onlineexam.controllers;

import com.tiantianchiji.onlineexam.dtos.Exam;
import com.tiantianchiji.onlineexam.dtos.ExamInfo;
import com.tiantianchiji.onlineexam.dtos.Question;
import com.tiantianchiji.onlineexam.services.EndUserExamService;
import com.tiantianchiji.onlineexam.services.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class EndUserExamController {
    @Autowired
    EndUserExamService _examService;

    @Autowired
    EndUserService _userService;

    @RequestMapping(value="{userid}/exams", method = RequestMethod.GET)
    public Exam getExam(@PathVariable long userid, @RequestParam(value="userToken") String userToken) {
        ExamInfo examInfo = null; // new ExamInfo(1, "English Level 4", "English level 4 exam", "Bo Zhou", 10, 60, 100 );

        Exam exam = new Exam();
        exam.setExamInfo(examInfo);

        ArrayList<Question> questions = new ArrayList<> ();

        return exam;
    }

    @RequestMapping(value="{userid}/examinsts", method = RequestMethod.GET)
    public Object getAllExams(@PathVariable long userid, @RequestParam(value="userToken") String userToken) {
        return null;
    }

    @RequestMapping(value="{userid}/examinsts/{examinstid}", method = RequestMethod.GET)
    public Object getExamReport(@PathVariable long userid, @RequestParam(value="userToken") String userToken, @PathVariable(value="examinstid") long examInstId) {
        return null;
    }

    @RequestMapping(value="{userid}/ongoingexams", method = RequestMethod.POST)
    public long startExam(@PathVariable long userid, @RequestParam(value="userToken") String userToken, @RequestParam(value="examId") long examId) {
        return -1;
    }

    @RequestMapping(value="{userid}/ongoingexams/{examinstid}", method = RequestMethod.GET)
    public Exam getQuestions(@PathVariable long userid, @RequestParam(value="userToken") String userToken, @PathVariable("examinstid") long examInstId) {
        return null;
    }

    @RequestMapping(value="{userid}/ongoingexams/{examinstid}", method = RequestMethod.PUT)
    public long finishExam(@PathVariable long userid, @RequestParam(value="userToken") String userToken, @PathVariable("examinstid") long examInstId) {
        return -1;
    }
}
