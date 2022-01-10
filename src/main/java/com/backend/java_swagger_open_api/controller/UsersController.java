package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.api.UsersApi;
import com.backend.java_swagger_open_api.models.User;
import com.backend.java_swagger_open_api.repository.UsersActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController implements UsersApi {

    @Autowired
    UsersActions usersActions;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(usersActions.getUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getOneUser(String username) {
        return new ResponseEntity<>(usersActions.getUser(username), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addOneUser(User user) {
            usersActions.addUser(user);
            return new ResponseEntity<>("User was added successfully", HttpStatus.OK);
    }
}
