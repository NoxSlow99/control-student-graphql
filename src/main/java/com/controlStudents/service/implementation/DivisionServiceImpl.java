package com.controlStudents.service.implementation;

import com.controlStudents.persistence.entities.Division;
import com.controlStudents.graphql.InputDivision;
import com.controlStudents.persistence.repository.IDivisionDAO;
import com.controlStudents.service.IDivisionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    private final IDivisionDAO divisionDAO;

    public DivisionServiceImpl(IDivisionDAO divisionDAO) {
        this.divisionDAO = divisionDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Division findById(Long id) {
        return divisionDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Division> findAll() {
        return divisionDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Division> findAllById(List<Long> ids) {
        return divisionDAO.findAllById(ids);
    }

    @Override
    @Transactional
    public Division createDivision(InputDivision inputDivision) {
        Division division = new Division();
        division.setName(inputDivision.name());

        return divisionDAO.save(division);
    }

    @Override
    @Transactional
    public Division updateDivision(Long id, InputDivision inputDivision) {
        Division division = findById(id);
        division.setName(inputDivision.name());

        return divisionDAO.save(division);
    }
}
