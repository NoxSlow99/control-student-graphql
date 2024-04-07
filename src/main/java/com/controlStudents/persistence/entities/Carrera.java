package com.controlStudents.persistence.entities;

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
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY, targetEntity = Student.class)
    private List<Student> students;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY, targetEntity = Campu.class)
    private List<Campu> campus;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id")
    private Division division;
}
