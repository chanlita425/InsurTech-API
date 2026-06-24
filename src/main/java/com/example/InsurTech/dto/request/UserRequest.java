package com.example.InsurTech.dto.request;

import com.example.InsurTech.enums.UserRole;
import com.example.InsurTech.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "Name is required")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "Email is required")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Password is required")
    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private UserRole role;

    @JsonProperty("status")
    private UserStatus status;
}