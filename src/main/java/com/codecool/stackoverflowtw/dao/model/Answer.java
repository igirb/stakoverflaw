package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public record Answer(int id, String message, LocalDateTime submission, int questionId) {
}
