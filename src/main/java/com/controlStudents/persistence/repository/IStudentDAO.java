package com.controlStudents.persistence.repository;

import com.controlStudents.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDAO extends JpaRepository<Student, Long> {
}
