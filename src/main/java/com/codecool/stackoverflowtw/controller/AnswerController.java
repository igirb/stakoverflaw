package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/question/{id}")
    public List<AnswerDTO> getAnswersByQuestionID(@PathVariable int id){
        List<AnswerDTO> answers = answerService.getAnswersByQuestionID(id);
        return answers;
    }

    @PostMapping("/")
    public int addNewAnswer(@RequestBody NewAnswerDTO answerDTO) throws SQLException {
        int resp = answerService.addNewAnswer(answerDTO);
        return resp;
    }
}
