package com.backend.java_swagger_open_api.repository;

import com.backend.java_swagger_open_api.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksInterface extends JpaRepository<Book, Integer> {

}
