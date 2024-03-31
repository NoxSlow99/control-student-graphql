package com.controlStudents.graphql;

import java.util.List;

public record InputCampu(
        Long id,
        String name,
        List<Long> carrerasId,
        List<Long> divisionesId
) {
}
