package com.example.springboot.springbootproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book", schema = "public")
public class Book {

    @Id
    @Column
    private Long id;

    @Column
    private String title;

    @Column(name = "page_number")
    private int pageNumber;

    @ManyToMany
    @JoinTable(
            name = "writer_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id")
    )
    private List<Writer> writers;
}
