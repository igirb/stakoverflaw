package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.service.QuestionService;
import com.codecool.stackoverflowtw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllQuestions() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public int addNewUser(@RequestBody NewUserDTO user) throws SQLException {
        userService.addNewUser(user);
        return 200;
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return true;
    }
}
