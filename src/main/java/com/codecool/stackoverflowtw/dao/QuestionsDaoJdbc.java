package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.DbConnector;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.time.LocalDateTime;
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
    public int addNewQuestion(NewQuestionDTO question) {
        //todo sql add to db
        // SQL query to insert a new question into the database
        String sql = "INSERT INTO questions (title, description, created) VALUES (?, ?, ?)";

        Connection databaseConnection;
        PreparedStatement preparedStatement;

        try {
            databaseConnection = getConnection();
            preparedStatement = databaseConnection.prepareStatement(sql);

            preparedStatement.setString(1, question.title());
            preparedStatement.setString(2, question.description());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.executeUpdate();

//            if (rowsAffected > 0) {
//                generatedKeys = preparedStatement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    newQuestionId = generatedKeys.getInt(1);
//                }
//            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 200;
    }
}
