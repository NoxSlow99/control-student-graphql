package com.controlStudents.persistence;

import com.controlStudents.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionDAO extends JpaRepository<Division, Long> {
}
