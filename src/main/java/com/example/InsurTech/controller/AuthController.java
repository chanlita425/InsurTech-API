package com.example.InsurTech.controller;

import com.example.InsurTech.dto.request.LoginRequest;
import com.example.InsurTech.service.serviceImp.AuthService;
import com.example.InsurTech.util.ApiResponse;
import com.example.InsurTech.util.ResponseBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@Valid @RequestBody LoginRequest request) {

        String result = authService.login(request);

        return ResponseEntity.ok(
                ResponseBuilder.successMessage(
                        200,
                        result
                )
        );
    }

}
