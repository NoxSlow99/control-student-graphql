package com.controlStudents.service.implementation;

import com.controlStudents.entities.Student;
import com.controlStudents.persistence.IStudentDAO;
import com.controlStudents.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentDAO.deleteById(id);
    }
}
