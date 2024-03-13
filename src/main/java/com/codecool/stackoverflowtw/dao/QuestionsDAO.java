package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;

public interface QuestionsDAO {
    List<Question> getAllQuestions();
    int addNewQuestion(NewQuestionDTO question) throws SQLException;
    boolean deleteQuestionById(int id);
    QuestionDTO getQuestionById(int id);

    List<Question> getAllQuestionsSorted();

    List<Question> getAllQuestionsSortedByDate();
}
