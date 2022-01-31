package com.backend.java_swagger_open_api.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Document("jwt_users")
public class User {

    @MongoId
    private String _id;
    @Size(min = 3, max = 25)
    private String username;
    @Size(min = 6, max = 50)
    private String password;
    private Address address;
    private Order[] orders;

    public User() {
    }

    public User(String _id, String username, String password, Address address, Order[] orders) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.orders = orders;
    }
}
