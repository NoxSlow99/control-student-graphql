package com.controlStudents.service;

import com.controlStudents.entities.Campu;
import com.controlStudents.graphql.InputCampu;

import java.util.List;

public interface ICampuService {

    Campu findById (Long id);
    List<Campu> findAll();
    Campu createCampu (InputCampu inputCampu);
    Campu updateCampu (Long id, InputCampu inputCampu);
    void deleteById (Long id);
}
