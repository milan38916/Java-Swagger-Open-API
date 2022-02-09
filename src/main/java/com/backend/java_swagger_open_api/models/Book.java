package com.backend.java_swagger_open_api.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


//@Entity
//@Table(name = "MyBooks")
@Document("books")
public class Book {

        //@Id
        //@GeneratedValue
        //@Column(name = "id", nullable = false)
        @MongoId
        private int _id;
        //@Column(name = "title", nullable = false)
        private String title;
        //@Column(name = "author", nullable = false)
        private String author;
        //@Column(name = "year", nullable = false)
        private int year;
        //@Column(name = "price", nullable = false)
        private int price;

        public Book() {
        }

        public Book(int _id, String title, String author, int year, int price) {
                this._id = _id;
                this.title = title;
                this.author = author;
                this.year = year;
                this.price = price;
        }

        public int getId() {
                return _id;
        }

        public void setId(int _id) {
                this._id = _id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public int getYear() {
                return year;
        }

        public void setYear(int year) {
                this.year = year;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }
}
