package com.controlStudents.exceptions;

import graphql.GraphQLError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

/*    @GraphQlExceptionHandler
    public GraphQLError handleException(Exception ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }*/

    @GraphQlExceptionHandler
    public GraphQLError handleValidationEmail(ConstraintViolationException ex) {
        // Obtén la primera violación (puedes personalizar esto según tus necesidades)
        ConstraintViolation<?> firstViolation = ex.getConstraintViolations().iterator().next();
        String fieldName = firstViolation.getPropertyPath().toString();
        String errorMessage = firstViolation.getMessage();

        return GraphQLError.newError()
                .message(errorMessage)
                .extensions(Map.of("field", fieldName)) // Agrega el nombre del campo
                .build();
    }

    @GraphQlExceptionHandler
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
