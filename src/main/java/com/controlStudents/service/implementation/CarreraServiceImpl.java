package com.controlStudents.service.implementation;

import com.controlStudents.entities.Carrera;
import com.controlStudents.entities.Division;
import com.controlStudents.graphql.InputCarrera;
import com.controlStudents.persistence.ICarreraDAO;
import com.controlStudents.service.ICarreraService;
import com.controlStudents.service.IDivisionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarreraServiceImpl implements ICarreraService {

    private final ICarreraDAO carreraDAO;
    private final IDivisionService divisionService;

    public CarreraServiceImpl(ICarreraDAO carreraDAO, IDivisionService divisionService) {
        this.carreraDAO = carreraDAO;
        this.divisionService = divisionService;
    }

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
    @Transactional(readOnly = true)
    public List<Carrera> findAllById(List<Long> ids) {
        return carreraDAO.findAllById(ids);
    }

    @Override
    @Transactional
    public Carrera createCarrera(InputCarrera inputCarrera) {
        Division division = divisionService.findById(inputCarrera.divisionId());

        Carrera carrera = new Carrera();
        carrera.setName(inputCarrera.name());
        carrera.setDivision(division);

        return carreraDAO.save(carrera);
    }

    @Override
    @Transactional
    public Carrera updateCarrera(Long id, InputCarrera inputCarrera) {
        Carrera carrera = findById(id);
        Division division = divisionService.findById(inputCarrera.divisionId());

        carrera.setName(inputCarrera.name());
        carrera.setDivision(division);

        return carreraDAO.save(carrera);
    }

    @Override
    @Transactional
    public void deleteCarrera(Long id) {
        carreraDAO.deleteById(id);
    }
}
