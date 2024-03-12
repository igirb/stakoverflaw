package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionsDAO questionsDAO;
    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> allQuestions = questionsDAO.getAllQuestions();
        // TODO convert data to QuestionDTO
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : allQuestions){
            questionDTOS.add(new QuestionDTO(question.id(), question.title(), question.description(), LocalDateTime.now()));
        }
        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public void addNewQuestion(NewQuestionDTO question) throws SQLException {
       questionsDAO.addNewQuestion(question);
    }
}
