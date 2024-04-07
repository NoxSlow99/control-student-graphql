package com.controlStudents.service;

import com.controlStudents.persistence.entities.Student;
import com.controlStudents.graphql.InputStudent;

import java.util.List;

public interface IStudentService {
    Student findById (Long id);
    List<Student> findAll();
    Student createStudent (InputStudent inputStudent);
    Student updateStudent (Long id, InputStudent inputStudent);
}
