package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswerDAO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public List<AnswerDTO> getAllAnswers() {
        throw new UnsupportedOperationException();
    }

    public AnswerDTO getAnswerById(int id) {
        throw new UnsupportedOperationException();
    }

    public boolean deleteAnswerById(int id) {
        throw new UnsupportedOperationException();
    }

    public int addNewAnswer(NewAnswerDTO answer) throws SQLException {
        Answer modelAnswer = new Answer(0, answer.message(), LocalDateTime.now(), answer.questionID());
        int resp = answerDAO.addNewAnswer(modelAnswer);
        return resp;
    }

    public List<AnswerDTO> getAnswersByQuestionID(int id) {
        List<Answer> answers = answerDAO.getAnswersByQuestionID(id);
        System.out.println("hhelz");
        List<AnswerDTO> answerDTOS = new ArrayList<>();
        for (Answer answer : answers) {
            answerDTOS.add(new AnswerDTO(answer.id(), answer.message(), answer.submission(), answer.questionID()));
        }
        return answerDTOS;
    }

}
