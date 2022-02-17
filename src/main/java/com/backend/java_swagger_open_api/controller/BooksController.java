package com.backend.java_swagger_open_api.controller;

import com.backend.java_swagger_open_api.models.Book;
import com.backend.java_swagger_open_api.models.CompleteBook;
import com.backend.java_swagger_open_api.models.SwaggerBook;
import com.backend.java_swagger_open_api.books.BooksActionsMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
public class BooksController implements BooksApi {

    /*@Autowired
    BooksActions booksActions;*/

    @Autowired
    BooksActionsMongoDB booksActionsMongoDB;

    @Override
    public ResponseEntity<String> addOneBook(SwaggerBook body) {
        CompleteBook book = new CompleteBook(body.getId(), body.getAuthors(), body.getIsbn(), body.getPageCount().intValue()
                ,body.getPublishedDate(), body.getCategories(), body.getLongDescription(), body.getShortDescription(), body.getStatus(),
                body.getThumbnailUrl(), body.getTitle(), body.getYear(), body.getPrice().intValue());
        booksActionsMongoDB.addOneBook(book);
        return new ResponseEntity<>("Book " + body.getTitle() + " was added to database.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CompleteBook>> getAllBooks() {
        return new ResponseEntity<>(booksActionsMongoDB.getAllBooks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CompleteBook> getOneBookByTitle(String title) {
        return new ResponseEntity<>(booksActionsMongoDB.getBookByTitle(title), HttpStatus.OK);
    }


}
