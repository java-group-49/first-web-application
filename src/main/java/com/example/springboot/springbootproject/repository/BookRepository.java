package com.example.springboot.springbootproject.repository;

import com.example.springboot.springbootproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "DELETE " +
            "FROM writer_book " +
            "WHERE writer_id = (SELECT id FROM writer WHERE name = :name) " +
            " AND book_id = (SELECT id FROM book WHERE title = :title)", nativeQuery = true)
    void detachBook(@Param("name") String name, @Param("title") String title);
}
