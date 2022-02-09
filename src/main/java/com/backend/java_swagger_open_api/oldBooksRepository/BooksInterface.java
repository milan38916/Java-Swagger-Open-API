/*package com.backend.java_swagger_open_api.oldBooksRepository;

import com.backend.java_swagger_open_api.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksInterface extends JpaRepository<Book, Integer> {

    @Query(value = " select * from my_books where title = ?1 ", nativeQuery = true)
    Book findByTitle(String title);

}
*/