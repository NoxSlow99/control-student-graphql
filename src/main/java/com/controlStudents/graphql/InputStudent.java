package com.controlStudents.graphql;


public record InputStudent(
        Long id,
        String name,
        Integer edad,
        String email,
        Long carreraId,
        Long campuId,
        Long divisionId
) {
}
