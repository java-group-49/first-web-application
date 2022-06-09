package com.example.springboot.springbootproject.service;

import com.example.springboot.springbootproject.model.Student;
import com.example.springboot.springbootproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        List<Student> out = new ArrayList<>();
        studentRepository.findAll().forEach(out::add);
        return out;
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student, String name) {
        studentRepository.updateUser(student.getAge(), student.getEducationalYear(), student.getName(), student.getLastName(), name);
    }

    public void deleteStudentByName(String name) {
        studentRepository.deleteStudentByName(name);
    }
}
