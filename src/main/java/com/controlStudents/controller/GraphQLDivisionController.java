package com.controlStudents.controller;

import com.controlStudents.entities.Division;
import com.controlStudents.graphql.InputDivision;
import com.controlStudents.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLDivisionController {
    @Autowired
    private IDivisionService divisionService;

    @QueryMapping(name = "findDivisionById")
    public Division findById(@Argument(name = "divisionId") String id) {
        Long divisionId = Long.parseLong(id);

        return divisionService.findById(divisionId);
    }

    @QueryMapping(name = "findAllDivision")
    public List<Division> findAll() {
        return divisionService.findAll();
    }

    @MutationMapping
    public Division createDivision(@Argument InputDivision inputDivision) {
        return divisionService.createDivision(inputDivision);
    }

    @MutationMapping
    public Division updateDivision(@Argument(name = "divisionId") String id, @Argument InputDivision inputDivision) {
        Long divisionId = Long.parseLong(id);

        return divisionService.updateDivision(divisionId, inputDivision);
    }

    @MutationMapping(name = "deleteDivisionById")
    public String deleteDivision(@Argument(name = "divisionId") String id) {
        divisionService.deleteDivision(Long.parseLong(id));

        return "División eliminado con éxito";
    }
}
