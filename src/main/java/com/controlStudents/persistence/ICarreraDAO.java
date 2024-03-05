package com.controlStudents.persistence;

import com.controlStudents.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarreraDAO extends JpaRepository<Carrera, Long> {
}
