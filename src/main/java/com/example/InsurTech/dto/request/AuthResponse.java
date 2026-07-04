package com.example.InsurTech.dto.request;

public record AuthResponse(
        String token,
        String type
) {}