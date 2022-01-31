package com.backend.java_swagger_open_api.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private OrderUser orderUser;
    private Address orderAddress;
    private String orderDate;
    private String numOfItems;
    private String orderID;
    private String price;
    private OrderBookItem[] orderBookItems;

    public Order() {
    }

    public Order(OrderUser orderUser, Address orderAddress, String orderDate, String numOfItems, String orderID, String price, OrderBookItem[] orderBookItems) {
        this.orderUser = orderUser;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
        this.numOfItems = numOfItems;
        this.orderID = orderID;
        this.price = price;
        this.orderBookItems = orderBookItems;
    }
}
