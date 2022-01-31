package com.backend.java_swagger_open_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBookItem {

    private String id;
    private String title;
    private String author;
    private String year;
    private String price;
    private String count;

    public OrderBookItem() {
    }

    public OrderBookItem(String id, String title, String author, String year, String price, String count) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.count = count;
    }


}
