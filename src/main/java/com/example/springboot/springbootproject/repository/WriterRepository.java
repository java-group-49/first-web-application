package com.example.springboot.springbootproject.repository;

import com.example.springboot.springbootproject.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface WriterRepository extends JpaRepository<Writer, Long> {
}
