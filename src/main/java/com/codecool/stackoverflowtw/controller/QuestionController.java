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
    //title, date, answersCount
    @GetMapping("/sorted/{criteria}")
    public List<QuestionDTO> getAllQuestionsSorted(@PathVariable String criteria) {
        return switch (criteria) {
            case "title" -> questionService.getAllQuestionsSorted();
            case "date" -> questionService.getAllQuestionsSortedByDate();
            case "answerCount" -> questionService.getAllQuestionsSortedByAnswer();
            default -> throw new IllegalArgumentException("No sorting criteria exists.");
        };
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
    @PostMapping("/increment/{id}")
    public void incrementAmountOfAnswers(@PathVariable int id) throws SQLException {
        questionService.incrementAmountOfAnswers(id);
    }
    @DeleteMapping("/{id}")
    public boolean deleteQuestionById(@PathVariable int id) {
//        TODO
        return questionService.deleteQuestionById(id);
    }
}
