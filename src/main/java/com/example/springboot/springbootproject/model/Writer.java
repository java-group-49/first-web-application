package com.example.springboot.springbootproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writer")
public class Writer {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "writers")
    private List<Book> books;
}
