package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.service.DbConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnswersDaoJdbc implements AnswerDAO {

    DbConnector dbConnector;

    public AnswersDaoJdbc(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Answer> getAllAnswers() {
        List<Answer> answers = new ArrayList<>();
        String sql = "SELECT * FROM answers";

        Connection databaseConnection;
        Statement statement;
        ResultSet resultSet;

        try {
            databaseConnection = dbConnector.getConnection();
            statement = databaseConnection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                answers.add(new Answer(resultSet.getInt("id"), resultSet.getString("message"), resultSet.getTimestamp("submission").toLocalDateTime(), resultSet.getInt("question_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return answers;
    }

    @Override
    public List<Answer> getAnswersByQuestionID(int id) {
        List<Answer> answers = new ArrayList<>();
        String sql = "SELECT * FROM answers WHERE question_id = ?";

        try (Connection databaseConnection = dbConnector.getConnection();
             PreparedStatement statement = databaseConnection.prepareStatement(sql)) {
            statement.setInt(1, id);
            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                answers.add(new Answer(resultSet.getInt("id"), resultSet.getString("message"), resultSet.getTimestamp("submission").toLocalDateTime(), resultSet.getInt("question_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return answers;
    }

    @Override
    public int addNewAnswer(Answer answer) {

        String sql = "INSERT INTO answers (message, submission, question_id) VALUES(?,?,?)";

        Connection databaseConnection;
        PreparedStatement preparedStatement;

        try {
            databaseConnection = dbConnector.getConnection();
            preparedStatement = databaseConnection.prepareStatement(sql);

            preparedStatement.setString(1, answer.message());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, answer.questionId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 200;
    }

    @Override
    public int updateAnswer(Answer answer) {
        String sql = "UPDATE answers SET message = ? WHERE id = ?";

        Connection databaseConnection;
        PreparedStatement preparedStatement;

        try {
            databaseConnection = dbConnector.getConnection();
            preparedStatement = databaseConnection.prepareStatement(sql);
            preparedStatement.setString(1, answer.message());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 200;
    }

    @Override
    public int deleteAnswer(int id) {
        String sql = "DELETE FROM answers WHERE id = ?";

        Connection databaseConnection;
        PreparedStatement preparedStatement;
        try {
            databaseConnection = dbConnector.getConnection();
            preparedStatement = databaseConnection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}
