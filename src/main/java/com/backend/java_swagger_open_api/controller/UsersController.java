package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.api.UsersApi;
import com.backend.java_swagger_open_api.models.User;
import com.backend.java_swagger_open_api.repository.UsersActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsersController implements UsersApi {

    @Autowired
    UsersActions usersActions;



    @GetMapping(value = "/user/{username}")
    public ResponseEntity<User> getAllUsers(@PathVariable String username) {
        return new ResponseEntity<>(usersActions.getUser(username), HttpStatus.OK);
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<String> addNewUser(@Valid @RequestBody User user, Errors errors) {
        if (!errors.hasErrors()) {
            usersActions.addUser(user);
            return new ResponseEntity<>("User was added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: " + errors.getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(usersActions.getUsers(), HttpStatus.OK);
    }
}
