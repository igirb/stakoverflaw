package com.codecool.stackoverflowtw.service;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class DbConnector {

    @Value("${askmate.database.url}")
    private String dbFile;
    @Value("${askmate.database.username}")
    private String username;
    @Value("${askmate.database.password}")
    private String password;



    public Connection getConnection() {
        Connection conn;
        try {
            String url = dbFile;
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to PSQL has been established.");
            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
