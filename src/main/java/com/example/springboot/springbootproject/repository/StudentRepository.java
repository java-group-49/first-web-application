package com.example.springboot.springbootproject.repository;

import com.example.springboot.springbootproject.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Transactional
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student getStudentByName(String name);
    void deleteStudentByName(String name);

    @Modifying
    @Query(value = "update Student s set s.age = ?1, s.educationalYear = ?2, s.name = ?3, s.lastName = ?4 where s.name = ?5")
    void updateUser(int age, int year, String newName, String lastName, String oldName);

}
