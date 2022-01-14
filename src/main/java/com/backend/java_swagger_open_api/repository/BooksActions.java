package com.backend.java_swagger_open_api.repository;

import com.backend.java_swagger_open_api.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableJpaRepositories
public class BooksActions {

    @Autowired
    BooksInterface booksInterface;

    public List<Book> getAllBooks() {
        return booksInterface.findAll();
    }

    public void addOneBook(Book book) {
        booksInterface.save(book);
    }

    public Book getOneBook(String title) {
        return booksInterface.findByTitle(title);
    }
}
