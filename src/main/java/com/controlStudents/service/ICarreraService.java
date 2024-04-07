package com.controlStudents.service;

import com.controlStudents.persistence.entities.Carrera;
import com.controlStudents.graphql.InputCarrera;

import java.util.List;

public interface ICarreraService {

    Carrera findById (Long id);
    List<Carrera> findAll();

    List<Carrera> findAllById(List<Long> ids);

    Carrera createCarrera (InputCarrera inputCarrera);
    Carrera updateCarrera (Long id, InputCarrera inputCarrera);
}
