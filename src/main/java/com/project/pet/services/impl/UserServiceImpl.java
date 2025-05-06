package com.project.pet.services.impl;

import java.util.List;

import com.project.pet.dto.request.UserLoginRequest;
import com.project.pet.dto.request.UserRegisterRequest;
import com.project.pet.dto.response.UserResponse;
import com.project.pet.entities.User;
import com.project.pet.repositories.UserRepository;
import com.project.pet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse registerUser(UserRegisterRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return null;
        }

        // Connect database to create user
        User userRegister = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .fullname(request.getFullname())
                .status(request.getStatus())
                .role(request.getRole())
                .build();
        userRegister = userRepository.save(userRegister);

        // Return response
        UserResponse userResponse = UserResponse.builder()
                .id(userRegister.getId())
                .email(userRegister.getEmail())
                .fullname(userRegister.getFullname())
                .status(userRegister.getStatus())
                .role(userRegister.getRole())
                .build();
        return userResponse;
    }

    @Override
    public UserResponse loginUser(UserLoginRequest request) {

        // Find user by email and password from database
        User userLogin = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElse(null);

        // If user not found, return null
        if (userLogin == null) {
            return null;
        }

        // Return response
        return UserResponse.builder()
                .email(userLogin.getEmail())
                .fullname(userLogin.getFullname())
                .status(userLogin.getStatus())
                .role(userLogin.getRole())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        // Get all users from database
        List<User> users = userRepository.findAll();

        // Map users to user responses
        return users.stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .fullname(user.getFullname())
                        .status(user.getStatus())
                        .role(user.getRole())
                        .build())
                .toList();
    }

}
