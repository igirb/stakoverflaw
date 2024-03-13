package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UsersDAO usersDAO;

    @Autowired
    public UserService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> allUsers = usersDAO.getAllUser();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : allUsers){
            userDTOS.add(new UserDTO(user.getId(), user.getUsername(), user.getCreated()));
        }
        return userDTOS;
    }

    public UserDTO getUserById(int id) {
        User user = usersDAO.getUserById(id);
        return new UserDTO(user.getId(), user.getUsername(), user.getCreated());
    }

    public boolean deleteUserById(int id) {
        return usersDAO.deleteUserById(id);
    }

    public void addNewUser(NewUserDTO user) throws SQLException {
        usersDAO.addNewUser(user);
    }
}
