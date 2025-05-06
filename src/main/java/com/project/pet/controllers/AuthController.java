package com.project.pet.controllers;

import com.project.pet.constants.UrlConstant;
import com.project.pet.dto.request.UserLoginRequest;
import com.project.pet.dto.request.UserRegisterRequest;
import com.project.pet.dto.response.UserResponse;
import com.project.pet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(UrlConstant.API_V1_AUTH_LOGIN)
    public UserResponse login(@RequestBody UserLoginRequest request) {
        return userService.loginUser(request);
    }

    @PostMapping(UrlConstant.API_V1_AUTH_REGISTER)
    public UserResponse register(@RequestBody UserRegisterRequest request) {
        return userService.registerUser(request);
    }
}
