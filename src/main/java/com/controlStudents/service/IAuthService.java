package com.controlStudents.service;

import com.controlStudents.graphql.AuthCreateUserRequest;
import com.controlStudents.graphql.AuthLoginRequest;
import com.controlStudents.graphql.AuthResponse;

public interface IAuthService {

    AuthResponse loginUser(AuthLoginRequest authLoginRequest);
    AuthResponse createUser(AuthCreateUserRequest createUserRequest);
}
