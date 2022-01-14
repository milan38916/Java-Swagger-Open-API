package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.models.Book;
import com.backend.java_swagger_open_api.models.SwaggerBook;
import com.backend.java_swagger_open_api.repository.BooksActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class BooksController implements BooksApi {

    @Autowired
    BooksActions booksActions;


    @Override
    public ResponseEntity<String> addOneBook(SwaggerBook body) {
        Book book = new Book(new BigDecimal(String.valueOf(body.getId())).intValue(), body.getAuthor(), body.getTitle(), new BigDecimal(String.valueOf(body.getYear())).intValue());
        booksActions.addOneBook(book);
        return new ResponseEntity<>("Book " + body.getTitle() + " was added to database.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(booksActions.getAllBooks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Book> getOneBookByTitle(String title) {
        return new ResponseEntity<>(booksActions.getOneBook(title), HttpStatus.OK);
    }


}