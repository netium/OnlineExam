package com.tiantianchiji.onlineexam.controllers;

import com.tiantianchiji.onlineexam.dtos.Exam;
import com.tiantianchiji.onlineexam.dtos.JsonResponse;
import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.services.EndUserExamService;
import com.tiantianchiji.onlineexam.services.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class EndUserExamController {
    @Autowired
    EndUserExamService _examService;

    @RequestMapping(value="/exams", method = RequestMethod.GET)
    public JsonResponse<List<ExamEntity>> getApplicableExams(@RequestParam(value="userToken") String userToken) {
        List<ExamEntity> exams = _examService.getAllApplicableExams(userToken);
        return new JsonResponse<List<ExamEntity>>().fillStatus(HttpStatus.OK).fillMessage("").fillBody(exams);
    }

    @RequestMapping(value="examinsts", method = RequestMethod.GET)
    public Object getAllExamInstances(@RequestParam(value="userToken") String userToken) {
        return null;
    }

    @RequestMapping(value="examinsts/{examinstid}", method = RequestMethod.GET)
    public Object getExamReport(@RequestParam(value="userToken") String userToken, @PathVariable(value="examinstid") long examInstId) {
        return null;
    }

    @RequestMapping(value="ongoingexams", method = RequestMethod.POST)
    public long startExam(@RequestParam(value="userToken") String userToken, @RequestParam(value="examId") long examId) {
        return -1;
    }

    @RequestMapping(value="ongoingexams/{examinstid}", method = RequestMethod.GET)
    public Exam getQuestions(@RequestParam(value="userToken") String userToken, @PathVariable("examinstid") long examInstId) {
        return null;
    }

    @RequestMapping(value="ongoingexams/{examinstid}", method = RequestMethod.PUT)
    public long finishExam(@RequestParam(value="userToken") String userToken, @PathVariable("examinstid") long examInstId) {
        return -1;
    }
}
