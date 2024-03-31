package com.controlStudents.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer edad;
    @Column(length = 50, nullable = false, unique = true)
    @Email
    private String email;

    @ManyToOne(targetEntity = Carrera.class)
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne(targetEntity = Campu.class)
    @JoinColumn(name = "campus_id")
    private Campu campu;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id")
    private Division division;
}
