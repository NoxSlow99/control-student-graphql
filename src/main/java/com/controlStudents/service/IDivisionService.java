package com.controlStudents.service;

import com.controlStudents.entities.Division;
import com.controlStudents.graphql.InputDivision;

import java.util.List;

public interface IDivisionService {
    Division findById (Long id);
    List<Division> findAll();
    List<Division> findAllById(List<Long> ids);
    Division createDivision (InputDivision inputDivision);
    Division updateDivision (Long id, InputDivision inputDivision);
    void deleteDivision (Long id);
}
