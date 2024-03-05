package com.controlStudents.service;

import com.controlStudents.entities.Division;

import java.util.List;

public interface IDivisionService {
    Division findById (Long id);
    List<Division> findAll();
    void createDivision (Division division);
    void deleteDivision (Long id);
}
