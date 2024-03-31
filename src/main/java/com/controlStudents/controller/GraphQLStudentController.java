package com.controlStudents.controller;

import com.controlStudents.entities.Student;
import com.controlStudents.graphql.InputStudent;
import com.controlStudents.service.IStudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {
    private final IStudentService studentService;

    public GraphQLStudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id) {
        Long studentId = Long.parseLong(id);

        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll () {
        return studentService.findAll();
    }

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent) {
        return studentService.createStudent(inputStudent);
    }

    @MutationMapping
    public Student updateStudent (@Argument(name = "studentId") String id, @Argument InputStudent inputStudent) {
        Long studentId = Long.parseLong(id);

        return studentService.updateStudent(studentId, inputStudent);
    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteById (@Argument(name = "studentId") String id) {
        studentService.deleteById(Long.parseLong(id));

        return "Estudiante eliminado con éxito";
    }
}
