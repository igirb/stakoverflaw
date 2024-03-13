package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record NewUserDTO(String username, String password, LocalDateTime created) {
}
