package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.models.Book;
import com.backend.java_swagger_open_api.repository.BooksActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController implements BooksApi {

    @Autowired
    BooksActions booksActions;


    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(booksActions.getAllBooks(), HttpStatus.OK);
    }


}
