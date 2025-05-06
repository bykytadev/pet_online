package com.project.pet.services;

import com.project.pet.dto.request.UserLoginRequest;
import com.project.pet.dto.request.UserRegisterRequest;
import com.project.pet.dto.response.UserResponse;

public interface AuthService {

    UserResponse registerUser(UserRegisterRequest request);

    UserResponse loginUser(UserLoginRequest request);
}
