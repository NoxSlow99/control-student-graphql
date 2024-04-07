package com.controlStudents.service.implementation;

import com.controlStudents.persistence.entities.Campu;
import com.controlStudents.persistence.entities.Carrera;
import com.controlStudents.persistence.entities.Division;
import com.controlStudents.persistence.entities.Student;
import com.controlStudents.graphql.InputStudent;
import com.controlStudents.persistence.repository.IStudentDAO;
import com.controlStudents.service.ICampuService;
import com.controlStudents.service.ICarreraService;
import com.controlStudents.service.IDivisionService;
import com.controlStudents.service.IStudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentDAO studentDAO;
    private final ICarreraService carreraService;
    private final ICampuService campuService;
    private final IDivisionService divisionService;

    public StudentServiceImpl(IStudentDAO studentDAO, ICarreraService carreraService,
                              ICampuService campuService, IDivisionService divisionService) {
        this.studentDAO = studentDAO;
        this.carreraService = carreraService;
        this.campuService = campuService;
        this.divisionService = divisionService;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDAO.findById(id).orElseThrow(
                () -> new RuntimeException("Student with ID not exist."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student createStudent(InputStudent inputStudent) {
        Carrera carrera = carreraService.findById(inputStudent.carreraId());
        Campu campu = campuService.findById(inputStudent.campuId());
        Division division = divisionService.findById(inputStudent.divisionId());

        Student student = new Student();
        return getStudent(inputStudent, student, carrera, campu, division);
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, InputStudent inputStudent) {
        Student student = findById(id);

        Carrera carrera = carreraService.findById(inputStudent.carreraId());
        Campu campu = campuService.findById(inputStudent.campuId());
        Division division = divisionService.findById(inputStudent.divisionId());

        return getStudent(inputStudent, student, carrera, campu, division);
    }

    @NotNull
    private Student getStudent(InputStudent inputStudent, Student student, Carrera carrera, Campu campu, Division division) {
        student.setName(inputStudent.name());
        student.setEdad(inputStudent.edad());
        student.setEmail(inputStudent.email());
        student.setCarrera(carrera);
        student.setCampu(campu);
        student.setDivision(division);

        return studentDAO.save(student);
    }
}
