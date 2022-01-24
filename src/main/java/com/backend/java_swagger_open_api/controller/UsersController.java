package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.models.SwaggerUser;
import com.backend.java_swagger_open_api.models.User;
import com.backend.java_swagger_open_api.models.UsernameObject;
import com.backend.java_swagger_open_api.repository.UsersActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UsersController implements UsersApi {

    @Autowired
    UsersActions usersActions;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(usersActions.getUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getOneUser(String username) {
        if (usersActions.getUser(username) != null) {
            return new ResponseEntity<>(usersActions.getUser(username), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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
        if (usersActions.getUser(newUser.getUsername()).getUsername().equals(newUser.getUsername())) {
            return new ResponseEntity<>("User with name " + newUser.getUsername() + " is already in system. Use other name.", HttpStatus.CONFLICT);
        } else {
            usersActions.addUser(user);
            return new ResponseEntity<>("User with name " + newUser.getUsername() + " was added successfully", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<User> changeUserName(UsernameObject body) {
        User user = usersActions.getUser(body.getOldusername());
        user.setUsername(body.getNewusername());
        usersActions.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
