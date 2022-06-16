package com.example.springboot.springbootproject;

import com.example.springboot.springbootproject.exception.UserNotFoundException;
import com.example.springboot.springbootproject.model.Student;
import com.example.springboot.springbootproject.repository.StudentRepository;
import com.example.springboot.springbootproject.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentsService studentsService;

    @Test
    public void studentsNotFoundTest() {
        when(studentRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(UserNotFoundException.class, () -> studentsService.getAllStudents(), "No users were found");
    }

    @Test
    public void studentsWereFoundTest() {
        Student student = new Student();
        when(studentRepository.findAll()).thenReturn(List.of(student));
        List<Student> students = studentsService.getAllStudents();
        assertEquals(1, students.size());
        verify(studentRepository, only()).findAll();
    }
}
