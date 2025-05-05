package com.project.pet.controllers;

import com.project.pet.constants.UrlConstant;
import com.project.pet.dto.request.UserLoginRequest;
import com.project.pet.dto.request.UserRegisterRequest;
import com.project.pet.dto.response.UserLoginResponse;
import com.project.pet.dto.response.UserRegisterResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping(UrlConstant.API_V1_AUTH_LOGIN)
    public Object login(@RequestBody UserLoginRequest request) {

        UserLoginResponse response = new UserLoginResponse();
        response.setEmail(request.getEmail());
        return response;

    }

    @PostMapping(UrlConstant.API_V1_AUTH_REGISTER)
    public Object register(@RequestBody UserRegisterRequest request) {

        UserRegisterResponse response = new UserRegisterResponse();
        response.setEmail(request.getEmail());
        response.setFullname(request.getFullname());
        response.setStatus(request.getStatus());
        response.setRole(request.getRole());

        return response;
    }
}
