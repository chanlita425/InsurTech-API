package com.example.InsurTech.dto.response;


import com.example.InsurTech.enums.UserRole;
import com.example.InsurTech.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private UserRole role;

    private UserStatus status;
}
