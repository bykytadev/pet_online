package com.project.pet.controllers;

import java.util.List;

import com.project.pet.constants.UrlConstant;
import com.project.pet.dto.response.UserResponse;
import com.project.pet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(UrlConstant.API_V1_USER)
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

}
