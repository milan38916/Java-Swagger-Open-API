package com.backend.java_swagger_open_api.books;

import com.backend.java_swagger_open_api.models.Book;
import com.backend.java_swagger_open_api.models.CompleteBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableMongoRepositories
public class BooksActionsMongoDB {

    @Autowired
    BooksRepositoryMongoDB books;

    public List<CompleteBook> getAllBooks() {
        return books.findAll();
    }

    public CompleteBook getBookByTitle(String title) {
        return books.getBookByTitle(title);
    }

    public void addOneBook(CompleteBook book) {
        books.save(book);
    }
}
