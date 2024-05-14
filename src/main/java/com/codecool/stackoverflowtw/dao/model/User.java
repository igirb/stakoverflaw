package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private final String username;
    private final int id;
    private String password;
    private final LocalDateTime created;

    public User(int id, String username, LocalDateTime created) {
        this.username = username;
        this.id = id;
        this.created = created;
    }

    public User(int id, String username, String password, LocalDateTime created) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.created = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
