package com.controlStudents.persistence.repository;

import com.controlStudents.persistence.entities.Campu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampuDAO extends JpaRepository<Campu, Long> {
}
