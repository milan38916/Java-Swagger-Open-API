package com.backend.java_swagger_open_api.models;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private OrderUser orderUser;
    private Address orderAddress;
    private String orderDate;
    private String numOfItems;
    private String orderID;
    private String price;
    private List<SwaggerOrderBookItem> orderBookItemList;

    public Order() {
    }

    public Order(OrderUser orderUser, Address orderAddress, String orderDate, String numOfItems, String orderID, String price, List<SwaggerOrderBookItem> orderBookItemList) {
        this.orderUser = orderUser;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
        this.numOfItems = numOfItems;
        this.orderID = orderID;
        this.price = price;
        this.orderBookItemList = orderBookItemList;
    }

    public OrderUser getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(OrderUser orderUser) {
        this.orderUser = orderUser;
    }

    public Address getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(Address orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(String numOfItems) {
        this.numOfItems = numOfItems;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<SwaggerOrderBookItem> getOrderBookItems() {
        return orderBookItemList;
    }

    public void setOrderBookItems(List<SwaggerOrderBookItem> orderBookItems) {
        this.orderBookItemList.addAll(orderBookItems);
    }
}
