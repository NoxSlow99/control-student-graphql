package com.controlStudents.service;

import com.controlStudents.entities.Student;

import java.util.List;

public interface IStudentService {
    Student findById (Long id);
    List<Student> findAll();
    void createStudent (Student student);
    void deleteStudent (Long id);
}
