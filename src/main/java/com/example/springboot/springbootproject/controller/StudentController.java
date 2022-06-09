package com.example.springboot.springbootproject.controller;

import com.example.springboot.springbootproject.model.Student;
import com.example.springboot.springbootproject.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentsService service;

    @Autowired
    public StudentController(StudentsService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/student/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        Student student = service.getStudentByName(name);

        if (student == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(student);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<Void> updateStudent(@PathVariable String name, @RequestBody Student student) {
        service.update(student, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String name) {
        service.deleteStudentByName(name);
        return ResponseEntity.status(202).build();
    }
}
