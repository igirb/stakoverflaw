package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record AnswerDTO(int id, String message, LocalDateTime submission, int questionID) {
}
