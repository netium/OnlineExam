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

    @Autowired
    EndUserService _userService;

    @RequestMapping(value="{userid}/exams", method = RequestMethod.GET)
    public JsonResponse<List<ExamEntity>> getApplicableExams(@PathVariable long userid, @RequestParam(value="userToken") String userToken) {

        JsonResponse<List<ExamEntity>> response = new JsonResponse<List<ExamEntity>>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("");
        List<ExamEntity> exams = _examService.getAllApplicableExams(userToken);
        response.setBody(exams);
        return response;
    }

    @RequestMapping(value="{userid}/examinsts", method = RequestMethod.GET)
    public Object getAllExamInstances(@PathVariable long userid, @RequestParam(value="userToken") String userToken) {
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
