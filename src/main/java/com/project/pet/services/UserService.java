package com.project.pet.services;

import java.util.List;

import com.project.pet.dto.response.UserResponse;

public interface UserService extends AuthService {

    List<UserResponse> getAllUsers();
}
