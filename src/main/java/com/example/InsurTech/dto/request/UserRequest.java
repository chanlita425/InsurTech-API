package com.example.InsurTech.dto.request;

import com.example.InsurTech.enums.UserRole;
import com.example.InsurTech.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private UserRole role;

    @JsonProperty("status")
    private UserStatus status;

}