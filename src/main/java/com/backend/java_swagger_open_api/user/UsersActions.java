package com.backend.java_swagger_open_api.user;

import com.backend.java_swagger_open_api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@EnableMongoRepositories
public class UsersActions {

    @Autowired
    UsersRepository usersRepository;

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User getUser(String username) {
        return usersRepository.getUserByUsername(username);
    }

    public User getUserByEmail(String email) {
        return usersRepository.getUserByEmail(email);
    }


    public Optional<User> getUserByID(String uid) {
        return usersRepository.findById(uid);
    }


    public void addUser(User user) {
        usersRepository.save(user);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return usersRepository.getUserByUsernameAndPassword(username, password);
    }


}
