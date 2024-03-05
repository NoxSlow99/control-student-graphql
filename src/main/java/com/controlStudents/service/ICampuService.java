package com.controlStudents.service;

import com.controlStudents.entities.Campu;

import java.util.List;

public interface ICampuService {

    Campu findById (Long id);
    List<Campu> findAll();
    void createCampu (Campu campu);
    void deleteById (Long id);
}
