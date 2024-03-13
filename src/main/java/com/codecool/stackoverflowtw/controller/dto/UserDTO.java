package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record UserDTO(int id, String username, LocalDateTime created) {
}
