package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.DbConnector;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {
    DbConnector dbConnector;

    public QuestionsDaoJdbc(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Question> getAllQuestions() {
        // TODO SQL query questions from database
        throw new UnsupportedOperationException();
    }
}
