package com.controlStudents.persistence;

import com.controlStudents.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDAO extends JpaRepository<Student, Long> {
}
