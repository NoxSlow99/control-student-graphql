package com.controlStudents.service.implementation;

import com.controlStudents.persistence.entities.Campu;
import com.controlStudents.persistence.entities.Carrera;
import com.controlStudents.persistence.entities.Division;
import com.controlStudents.graphql.InputCampu;
import com.controlStudents.persistence.repository.ICampuDAO;
import com.controlStudents.service.ICampuService;
import com.controlStudents.service.ICarreraService;
import com.controlStudents.service.IDivisionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampuServiceImpl implements ICampuService {

    private final ICampuDAO campuDAO;
    private final ICarreraService carreraService;
    private final IDivisionService divisionService;

    public CampuServiceImpl(ICampuDAO campuDAO, ICarreraService carreraService, IDivisionService divisionService) {
        this.campuDAO = campuDAO;
        this.carreraService = carreraService;
        this.divisionService = divisionService;
    }

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
    public Campu createCampu(InputCampu inputCampu) {
        List<Carrera> carreras = carreraService.findAllById(inputCampu.carrerasId());
        List<Division> divisions = divisionService.findAllById(inputCampu.divisionesId());

        Campu campu = new Campu();
        campu.setName(inputCampu.name());
        campu.setCarreras(carreras);
        campu.setDivisiones(divisions);

        return campuDAO.save(campu);
    }

    @Override
    @Transactional
    public Campu updateCampu(Long id, InputCampu inputCampu) {
        Campu campu = findById(id);

        List<Carrera> carreras = carreraService.findAllById(inputCampu.carrerasId());
        List<Division> divisions = divisionService.findAllById(inputCampu.divisionesId());

        campu.setName(inputCampu.name());
        campu.setCarreras(carreras);
        campu.setDivisiones(divisions);

        return campuDAO.save(campu);
    }
}
