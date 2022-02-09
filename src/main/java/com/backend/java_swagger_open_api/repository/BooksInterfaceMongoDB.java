package com.backend.java_swagger_open_api.repository;

import com.backend.java_swagger_open_api.models.Book;
import com.backend.java_swagger_open_api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksInterfaceMongoDB extends MongoRepository<Book, Integer> {

    @Query("{title: '?0'}")
    Book getBookByTitle(String title);

}
