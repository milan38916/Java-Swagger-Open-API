package com.backend.java_swagger_open_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBookItem {

    private int id;
    private String title;
    private String author;
    private int year;
    private int price;
    private int count;

    public OrderBookItem() {
    }

    public OrderBookItem(int id, String title, String author, int year, int price, int count) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.count = count;
    }
}
