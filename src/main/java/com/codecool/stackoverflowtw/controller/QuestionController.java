package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/sorted/title")
    public List<QuestionDTO> getAllQuestionsSorted() {
        return questionService.getAllQuestionsSorted();
    }
    @GetMapping("/sorted/date")
    public List<QuestionDTO> getAllQuestionsSortedByDate() {
        return questionService.getAllQuestionsSortedByDate();
    }
    @GetMapping("/all")
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
//        TODO
        return questionService.getQuestionById(id);
    }

    @PostMapping("/add")
    public int addNewQuestion(@RequestBody NewQuestionDTO question) throws SQLException {
//        TODO
        questionService.addNewQuestion(question);
        return 1;
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuestionById(@PathVariable int id) {
//        TODO
        return questionService.deleteQuestionById(id);
    }
}
