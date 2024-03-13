package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.DbConnector;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {

    DbConnector dbConnector;

    public QuestionsDaoJdbc(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT id,title, description from questions";
        return getQuestions(sql);
    }
    public int addNewQuestion(NewQuestionDTO question) {
        //todo sql add to db
        // SQL query to insert a new question into the database
        String sql = "INSERT INTO questions (title, description, created) VALUES (?, ?, ?)";

        Connection databaseConnection;
        PreparedStatement preparedStatement;

        try {
            databaseConnection = dbConnector.getConnection();
            preparedStatement = databaseConnection.prepareStatement(sql);

            preparedStatement.setString(1, question.title());
            preparedStatement.setString(2, question.description());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 200;
    }

    @Override
    public boolean deleteQuestionById(int id) {
        String sql = "DELETE FROM questions where id = ?";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            pstmt.executeQuery();

            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public QuestionDTO getQuestionById(int id) {
        //todo: this
        String sql = "SELECT FROM questions WHERE id = ?";
        QuestionDTO questionDTO = null;

        try (Connection conn = dbConnector.getConnection();
        PreparedStatement pstmnt = conn.prepareStatement(sql)){

            ResultSet rs = pstmnt.executeQuery();

            while (rs.next()) {
                int questionId = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                questionDTO = new QuestionDTO(questionId, title, description, LocalDateTime.now());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return questionDTO;
    }

    @Override
    public List<Question> getAllQuestionsSorted() {
        String sql = "SELECT id,title, description from questions ORDER BY title ASC";
        return getQuestions(sql);
    }

    private List<Question> getQuestions(String sql) {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                Question question = new Question(id, title, description);
                questions.add(question);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return questions;
    }

    @Override
    public List<Question> getAllQuestionsSortedByDate() {
        String sql = "SELECT id,title, description from questions ORDER BY created DESC";
        return getQuestions(sql);
    }

}
