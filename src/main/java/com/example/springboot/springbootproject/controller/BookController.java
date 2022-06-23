package com.example.springboot.springbootproject.controller;

import com.example.springboot.springbootproject.model.Book;
import com.example.springboot.springbootproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookService.getAllBooks());
    }

    @DeleteMapping("/book/{author}/{title}")
    public ResponseEntity<Void> detachBook(@PathVariable(value = "author") String author,
                                           @PathVariable(value = "title") String bookTitle) {
        bookService.detachBook(author, bookTitle);
        return ResponseEntity.ok().build();
    }
}
