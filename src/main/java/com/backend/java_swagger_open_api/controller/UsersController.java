package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.models.*;
import com.backend.java_swagger_open_api.user.UsersActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UsersController implements UsersApi {

    @Autowired
    UsersActions usersActions;


    @RequestMapping(value = "/")
    public String index() {
        System.out.println("swagger-ui.html");
        return "swagger-ui.html";
    }


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

    @CrossOrigin(origins = "http://localhost:3000")
    @Override
    public ResponseEntity<List<Order>> getUserOrders(String userID) {
        Optional<User> user = usersActions.getUserByID(userID);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get().getOrders(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<Order>(), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<User> login(LoginUser body) {
        if (usersActions.getUserByUsernameAndPassword(body.getUsername(), body.getPassword()) != null) {
            return new ResponseEntity<>(usersActions.getUserByUsernameAndPassword(body.getUsername(), body.getPassword()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @Override
    public ResponseEntity<String> setNewAddress(SwaggerAddress body) {
        Optional<User> user = usersActions.getUserByID(body.getId());

        if (user.isPresent()) {
            user.get().setAddress(new Address(body.getCity(), body.getStreet(), body.getPostalCode()));
            usersActions.addUser(user.get());
            return new ResponseEntity<>("Address was successfuly added to user with name " + user.get().getUsername() + ".", HttpStatus.OK);
        }   else {
            return new ResponseEntity<>("Some error", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<String> setNewOrder(UserOrder body) {
        Optional<User> user = usersActions.getUserByID(body.getId());
        if (user.isPresent()) {
            OrderUser orderUser = new OrderUser(body.getOrderUser().getName(), body.getOrderUser().getSurname(), body.getOrderUser().getEmail(), body.getOrderUser().getPhoneNumber());
            Address address = new Address(body.getOrderAddress().getCity(),body.getOrderAddress().getStreet(),body.getOrderAddress().getPostalCode());
            user.get().setOrders(new Order(orderUser, address, body.getOrderDate(), body.getNumOfItems().toString(), body.getOrderID(), body.getPrice().toString(), body.getOrderBookItems()));
            usersActions.addUser(user.get());
            return new ResponseEntity<>("Succesfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateUser(SwaggerUser updatedUser) {
        User user = new User(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getPassword(), new Address(), updatedUser.getEmail());
        usersActions.addUser(user);
        return new ResponseEntity<>("User with name " + updatedUser.getUsername() + " was updated.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addOneUser(SwaggerUser newUser) {
        User user = new User(newUser.getId(), newUser.getUsername(), newUser.getPassword(), null, newUser.getEmail());
        if (usersActions.getUser(newUser.getUsername()) != null) {
            return new ResponseEntity<>("User with name " + newUser.getUsername() + " is already in system. Use other name.", HttpStatus.CONFLICT);
        } else if (usersActions.getUserByEmail(newUser.getEmail()) != null) {
            return new ResponseEntity<>("User with email " + newUser.getEmail() + " is already in system. Use other name.", HttpStatus.CONFLICT);
        } else {
            usersActions.addUser(user);
            return new ResponseEntity<>("User with name " + newUser.getUsername() + " was added successfully", HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<String> changePassword(PasswordObject body) {
        User user = usersActions.getUser(body.getUsername());
        if (user.getPassword().equals(body.getOldpassword())) {
            user.setPassword(body.getNewpassword());
            usersActions.addUser(user);
            return new ResponseEntity<>("Password was successfully changed.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong old password, try it again.", HttpStatus.NO_CONTENT);
        }

    }

    @Override
    public ResponseEntity<User> changeUserEmail(EmailObject body) {
        User user = usersActions.getUserByEmail(body.getOldemail());
        System.out.println(body.getNewemail() + " " + body.getOldemail());
        if (user.getEmail().equals(body.getNewemail()) || usersActions.getUserByEmail(body.getNewemail()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            user.setEmail(body.getNewemail());
            usersActions.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<User> changeUserName(UsernameObject body) {
        User user = usersActions.getUser(body.getOldusername());
        if (usersActions.getUser(body.getNewusername()) != null && usersActions.getUser(body.getNewusername()).getUsername().equals(body.getNewusername())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            user.setUsername(body.getNewusername());
            usersActions.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<String> deleteUserAddress(String userID) {
        Optional<User> user = usersActions.getUserByID(userID);
        if (user.isPresent()) {
            user.get().setAddress(null);
            usersActions.addUser(user.get());
            return new ResponseEntity<>("Address was successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error.", HttpStatus.BAD_REQUEST);
    }

}
