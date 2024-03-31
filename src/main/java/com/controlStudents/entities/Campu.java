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
@Table(name = "campus")
public class Campu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "campu", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Student.class)
    private List<Student> students;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Carrera.class)
    @JoinTable(
            name = "campus_carrera",
            joinColumns = @JoinColumn(name = "campus_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private List<Carrera> carreras;

    @ManyToMany(targetEntity = Division.class)
    @JoinTable(
            name = "campus_division",
            joinColumns = @JoinColumn(name = "campus_id"),
            inverseJoinColumns = @JoinColumn(name = "division_id")
    )
    private List<Division> divisiones;
}
