package com.controlStudents.service;

import com.controlStudents.entities.Carrera;
import com.controlStudents.graphql.InputCarrera;

import java.util.List;

public interface ICarreraService {

    Carrera findById (Long id);
    List<Carrera> findAll();

    List<Carrera> findAllById(List<Long> ids);

    Carrera createCarrera (InputCarrera inputCarrera);
    Carrera updateCarrera (Long id, InputCarrera inputCarrera);
    void deleteCarrera (Long id);
}
