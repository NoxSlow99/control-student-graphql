package com.controlStudents.exceptions;

import graphql.GraphQLError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler(DataIntegrityViolationException.class)
    public GraphQLError handleDuplicateData(DataIntegrityViolationException ex) {
        String messageException = ex.getMessage();

        int startIndex = messageException.indexOf("'") + 1;
        int endIndex = messageException.indexOf("'", startIndex);
        String duplicateEmail = "El correo electrónico '" + messageException.substring(startIndex, endIndex)
                + "' ya existe en la base de datos";


        return GraphQLError.newError()
                .message(duplicateEmail)
                .build();
    }
}
