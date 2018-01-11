package com.tiantianchiji.onlineexam.controllers;

import com.tiantianchiji.onlineexam.dtos.Answer;
import com.tiantianchiji.onlineexam.dtos.AskFormQuestion;
import com.tiantianchiji.onlineexam.dtos.ExamReport;
import com.tiantianchiji.onlineexam.dtos.JsonResponse;
import com.tiantianchiji.onlineexam.entities.ExamEntity;
import com.tiantianchiji.onlineexam.entities.QuestionEntity;
import com.tiantianchiji.onlineexam.services.EndUserExamService;
import com.tiantianchiji.onlineexam.services.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public JsonResponse<ExamReport> getExamReport(@RequestParam(value="userToken") String userToken, @PathVariable(value="examinstid") long examInstId) {
        ExamReport report = _examService.getExamInstanceReport(userToken, examInstId);
        if (report == null) {
            return new JsonResponse<ExamReport>().fillStatus(HttpStatus.FORBIDDEN).fillMessage("").fillBody(null);
        }
        else {
            return new JsonResponse<ExamReport>().fillStatus(HttpStatus.OK).fillMessage("").fillBody(report);
        }
    }

    @RequestMapping(value="ongoingexams", method = RequestMethod.POST)
    public JsonResponse<Long> startExam(@RequestParam(value="userToken") String userToken, @RequestBody Long examId) {
        long examInstanceId = _examService.createNewExamInstance(userToken, examId);
        if (examInstanceId < 0) {
            return new JsonResponse<Long>().fillStatus(HttpStatus.FORBIDDEN).fillMessage("Create exam failed!");
        }
        else {
            return new JsonResponse<Long>().fillStatus(HttpStatus.CREATED).fillMessage("Create exam succeed!").fillBody(examInstanceId);
        }
    }

    @RequestMapping(value="ongoingexams/{examinstid}/questions", method = RequestMethod.GET)
    public JsonResponse<List<AskFormQuestion>> getOngoingExamQuestions(@RequestParam(value="userToken") String userToken, @PathVariable("examinstid") long examInstId) {

        List<QuestionEntity> questions = _examService.getQuestionsForExamInstance(userToken, examInstId);
        if (questions == null) {
            return new JsonResponse<List<AskFormQuestion>>().fillStatus(HttpStatus.NOT_FOUND).fillMessage("Can not get questions").fillBody(null);
        }
        else {
            List<AskFormQuestion> askFormQuestions = new ArrayList<AskFormQuestion>();
            for (QuestionEntity entity : questions) {
                askFormQuestions.add(AskFormQuestion.fromEntity(entity));
            }

            return new JsonResponse<List<AskFormQuestion>>().fillStatus(HttpStatus.OK).fillMessage("Question getting succeed").fillBody(askFormQuestions);
        }
    }

    @RequestMapping(value="ongoingexams/{examinstid}", method = RequestMethod.PUT)
    public JsonResponse<Void> finishExam(@RequestParam(value="userToken") String userToken, @PathVariable("examinstid") long examInstId, @RequestBody Answer[] answers) {
        int ret = _examService.submitExam(userToken, examInstId, answers);
        JsonResponse<Void> response = new JsonResponse<Void>();
        switch (ret) {
            case -1:
                response.fillStatus(HttpStatus.UNAUTHORIZED);
                break;
            case -2:
                response.fillStatus(HttpStatus.NOT_FOUND);
                break;
            case -3:
                response.fillStatus(HttpStatus.FORBIDDEN);
                break;
            case -4:
                response.fillStatus(HttpStatus.FORBIDDEN);
                break;
            default:
                response.fillStatus(HttpStatus.OK);
                break;
        }
        response.fillMessage("").fillBody(null);
        return response;
    }
}
