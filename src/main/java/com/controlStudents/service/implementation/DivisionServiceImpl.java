package com.controlStudents.service.implementation;

import com.controlStudents.entities.Division;
import com.controlStudents.persistence.IDivisionDAO;
import com.controlStudents.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    private IDivisionDAO divisionDAO;

    @Override
    @Transactional(readOnly = true)
    public Division findById(Long id) {
        return divisionDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Division> findAll() {
        return divisionDAO.findAll();
    }

    @Override
    @Transactional
    public void createDivision(Division division) {
        divisionDAO.save(division);
    }

    @Override
    @Transactional
    public void deleteDivision(Long id) {
        divisionDAO.deleteById(id);
    }
}
