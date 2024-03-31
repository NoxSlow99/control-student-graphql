package com.controlStudents.controller;

import com.controlStudents.entities.Carrera;
import com.controlStudents.graphql.InputCarrera;
import com.controlStudents.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCarreraController {
    @Autowired
    private ICarreraService carreraService;

    @QueryMapping(name = "findCarreraById")
    public Carrera findById(@Argument(name = "carreraId") String id) {
        Long carreraId = Long.parseLong(id);

        return carreraService.findById(carreraId);
    }

    @QueryMapping(name = "findAllCarreras")
    public List<Carrera> findAll () {
        return carreraService.findAll();
    }

    @MutationMapping
    public Carrera createCarrera(@Argument InputCarrera inputCarrera) {
        return carreraService.createCarrera(inputCarrera);
    }

    @MutationMapping
    public Carrera updateCarrera (@Argument(name = "carreraId") String id, @Argument InputCarrera inputCarrera) {
        Long carreraId = Long.parseLong(id);

        return carreraService.updateCarrera(carreraId, inputCarrera);
    }

    @MutationMapping(name = "deleteCarreraById")
    public String deleteCarrera(@Argument(name = "carreraId") String id) {
        carreraService.deleteCarrera(Long.parseLong(id));

        return "Carrera eliminado con éxito";
    }
}
