package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.models.User;
import com.backend.java_swagger_open_api.repository.UsersActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersActions usersActions;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return usersActions.getUsers();
    }
}
