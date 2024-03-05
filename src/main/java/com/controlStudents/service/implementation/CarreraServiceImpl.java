package com.controlStudents.service.implementation;

import com.controlStudents.entities.Carrera;
import com.controlStudents.persistence.ICarreraDAO;
import com.controlStudents.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarreraServiceImpl implements ICarreraService {

    @Autowired
    private ICarreraDAO carreraDAO;

    @Override
    @Transactional(readOnly = true)
    public Carrera findById(Long id) {
        return carreraDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrera> findAll() {
        return carreraDAO.findAll();
    }

    @Override
    @Transactional
    public void createCarrera(Carrera carrera) {
        carreraDAO.save(carrera);
    }

    @Override
    @Transactional
    public void deleteCarrera(Long id) {
        carreraDAO.deleteById(id);
    }
}
