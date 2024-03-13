package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Answer;

import java.sql.SQLException;
import java.util.List;

public interface AnswerDAO {
    List<Answer> getAllAnswers();

    List<Answer> getAnswersByQuestionID(int id);

    int addNewAnswer(Answer answer) throws SQLException;

    int updateAnswer(Answer answer);

    boolean deleteAnswer(int id);
    boolean deleteAll();
}
