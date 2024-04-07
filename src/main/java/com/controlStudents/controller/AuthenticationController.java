package com.controlStudents.controller;

import com.controlStudents.graphql.AuthCreateUserRequest;
import com.controlStudents.graphql.AuthLoginRequest;
import com.controlStudents.graphql.AuthResponse;
import com.controlStudents.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {

    @Autowired
    private IAuthService authService;

    @MutationMapping
    public AuthResponse login(@Argument @Valid AuthLoginRequest authLoginRequest) {
        return authService.loginUser(authLoginRequest);
    }

    @MutationMapping
    public AuthResponse register(@Argument @Valid AuthCreateUserRequest userRequest) {
        return authService.createUser(userRequest);
    }
}
