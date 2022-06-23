package com.example.springboot.springbootproject.service;

import com.example.springboot.springbootproject.exception.UserNotFoundException;
import com.example.springboot.springbootproject.model.Student;
import com.example.springboot.springbootproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {

    private final StudentRepository studentRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public StudentsService(StudentRepository studentRepository, JavaMailSender javaMailSender) {
        this.studentRepository = studentRepository;
        this.javaMailSender = javaMailSender;
    }

    public List<Student> getAllStudents() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("accforgit49@gmail.com");
        message.setTo("dzinoveev@gmail.com");
        message.setSubject("Test subject");
        message.setText("Test text");
        javaMailSender.send(message);

        return new ArrayList<>();
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
