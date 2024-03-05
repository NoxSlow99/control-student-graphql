package com.controlStudents.service.implementation;

import com.controlStudents.entities.Campu;
import com.controlStudents.persistence.ICampuDAO;
import com.controlStudents.service.ICampuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampuServiceImpl implements ICampuService {

    @Autowired
    ICampuDAO campuDAO;

    @Override
    @Transactional(readOnly = true)
    public Campu findById(Long id) {
        return campuDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Campu> findAll() {
        return campuDAO.findAll();
    }

    @Override
    @Transactional
    public void createCampu(Campu campu) {
        campuDAO.save(campu);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        campuDAO.deleteById(id);
    }
}
