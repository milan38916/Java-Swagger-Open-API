package com.backend.java_swagger_open_api.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document("jwt_users")
public class User {

    @MongoId
    private String _id;
    private String username;
    private String password;

    public User() {
    }

    public User(String _id, String username, String password) {
        this._id = _id;
        this.username = username;
        this.password = password;
    }
}
