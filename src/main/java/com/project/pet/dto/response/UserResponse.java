package com.project.pet.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private Integer id;
    private String email;
    private String fullname;
    private String status;
    private String role;
}
