package com.controlStudents.persistence.repository;

import com.controlStudents.persistence.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarreraDAO extends JpaRepository<Carrera, Long> {
}
