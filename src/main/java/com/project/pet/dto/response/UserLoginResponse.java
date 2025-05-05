package com.project.pet.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponse {
    private String email;
    private String fullname;
    private String status;
    private String role;
}
