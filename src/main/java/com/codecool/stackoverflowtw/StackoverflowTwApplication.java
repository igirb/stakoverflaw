package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDaoJdbc;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.UsersDaoJdbc;
import com.codecool.stackoverflowtw.service.DbConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StackoverflowTwApplication {

//    TODO: Add the url of your database to the Environment Variables of the Run Configuration


    //@Value("${askmate.database.url}")
    //private String databaseUrl;
    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
        System.out.println("http://localhost:8080");
    }
    @Bean
    public QuestionsDAO questionsDAO(DbConnector dbConnector) {
        return new QuestionsDaoJdbc(dbConnector);
    }
    @Bean
    public UsersDAO usersDAO(DbConnector dbConnector) {
        return new UsersDaoJdbc(dbConnector);
    }

    @Bean
    public DbConnector dbConnector() { return new DbConnector(); }
}
