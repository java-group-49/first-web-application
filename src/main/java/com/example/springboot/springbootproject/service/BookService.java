package com.example.springboot.springbootproject.service;

import com.example.springboot.springbootproject.model.Book;
import com.example.springboot.springbootproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.findAll());
    }
}
