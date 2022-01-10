package com.backend.java_swagger_open_api.repository;

import com.backend.java_swagger_open_api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addUser(User user) {
        if (user != null) {
            usersRepository.save(user);
        }
    }

}
