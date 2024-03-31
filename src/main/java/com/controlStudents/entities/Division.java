package com.controlStudents.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Student.class)
    private List<Student> students;

    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = Carrera.class)
    private List<Carrera> carreras;

    @ManyToMany(mappedBy = "divisiones", targetEntity = Campu.class)
    private List<Campu> campus;
}
