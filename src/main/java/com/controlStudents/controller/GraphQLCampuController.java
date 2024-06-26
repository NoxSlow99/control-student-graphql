package com.controlStudents.controller;

import com.controlStudents.persistence.entities.Campu;
import com.controlStudents.graphql.InputCampu;
import com.controlStudents.service.ICampuService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCampuController {
    private final ICampuService campuService;

    public GraphQLCampuController(ICampuService campuService) {
        this.campuService = campuService;
    }

    @QueryMapping(name = "findCampuById")
    @PreAuthorize("hasRole('INVITED')")
    public Campu findById (@Argument(name = "campuId") String id) {
        Long campuId = Long.parseLong(id);

        return campuService.findById(campuId);
    }

    @QueryMapping(name = "findAllCampu")
    @PreAuthorize("hasRole('INVITED')")
    public List<Campu> findAll() {
        return campuService.findAll();
    }

    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Campu createCampu(@Argument InputCampu inputCampu) {
        return campuService.createCampu(inputCampu);
    }

    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Campu updateCampu(@Argument(name = "campuId") String id, @Argument InputCampu inputCampu) {
        Long campuId = Long.parseLong(id);

        return campuService.updateCampu(campuId, inputCampu);
    }
}
