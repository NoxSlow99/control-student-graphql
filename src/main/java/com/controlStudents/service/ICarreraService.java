package com.controlStudents.service;

import com.controlStudents.entities.Carrera;

import java.util.List;

public interface ICarreraService {

    Carrera findById (Long id);
    List<Carrera> findAll();
    void createCarrera (Carrera carrera);
    void deleteCarrera (Long id);
}
