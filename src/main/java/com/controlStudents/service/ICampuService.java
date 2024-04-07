package com.controlStudents.service;

import com.controlStudents.persistence.entities.Campu;
import com.controlStudents.graphql.InputCampu;

import java.util.List;

public interface ICampuService {

    Campu findById (Long id);
    List<Campu> findAll();
    Campu createCampu (InputCampu inputCampu);
    Campu updateCampu (Long id, InputCampu inputCampu);
}
