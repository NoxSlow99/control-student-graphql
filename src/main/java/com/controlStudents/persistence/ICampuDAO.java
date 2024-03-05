package com.controlStudents.persistence;

import com.controlStudents.entities.Campu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampuDAO extends JpaRepository<Campu, Long> {
}
