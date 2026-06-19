package com.example.InsurTech.controller;

import com.example.InsurTech.dto.response.UserResponse;
import com.example.InsurTech.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // list
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

}