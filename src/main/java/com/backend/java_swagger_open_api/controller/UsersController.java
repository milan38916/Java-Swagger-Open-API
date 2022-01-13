package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.controller.UsersApi;
import com.backend.java_swagger_open_api.models.SwaggerUser;
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
    public ResponseEntity<String> updateUser(SwaggerUser updatedUser) {
        User user = new User(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getPassword());
        usersActions.addUser(user);
        return new ResponseEntity<>("User with name " + updatedUser.getUsername() + " was updated.", HttpStatus.OK);
    }


    @Override
    public ResponseEntity<String> addOneUser(SwaggerUser newUser) {
            User user = new User(newUser.getId(), newUser.getUsername(), newUser.getPassword());
            usersActions.addUser(user);
            return new ResponseEntity<>("User was added successfully", HttpStatus.OK);
    }
}
