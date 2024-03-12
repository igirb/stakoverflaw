package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuestionsDAO {
    List<Question> getAllQuestions();
    int addNewQuestion(NewQuestionDTO question) throws SQLException;
}
