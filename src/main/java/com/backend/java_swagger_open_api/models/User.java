package com.backend.java_swagger_open_api.models;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Document("users")
public class User {

    @MongoId
    private String _id;
    @Size(min = 3, max = 25)
    private String username;
    @Size(min = 6, max = 50)
    private String password;
    private Address address;
    private List<Order> orders = new ArrayList<Order>();
    private String email;

    public User() {
    }

    public User(String _id, String username, String password, Address address, String email) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order order) {
        this.orders.add(order);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
