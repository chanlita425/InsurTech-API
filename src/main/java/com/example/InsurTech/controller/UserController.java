package com.example.InsurTech.controller;

import com.example.InsurTech.dto.request.UserRequest;
import com.example.InsurTech.dto.response.UserResponse;
import com.example.InsurTech.service.service.UserService;
import com.example.InsurTech.util.ApiResponse;
import com.example.InsurTech.util.PageResponse;
import com.example.InsurTech.util.ResponseBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<UserResponse>>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        PageResponse<UserResponse> result = userService.getUsers(page, size);

        return ResponseEntity.ok(
                ResponseBuilder.success(
                        200,
                        "Users retrieved successfully",
                        result
                )
        );
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getById(
            @PathVariable Long id) {

        UserResponse user = userService.getUserById(id);

        return ResponseEntity.ok(
                ResponseBuilder.success(
                        200,
                        "User fetched successfully",
                        user
                )
        );
    }

    //create
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createUser(
            @Valid @RequestBody UserRequest request) {

        UserResponse response =
                userService.createUser(request);

        return ResponseEntity.ok(
                ResponseBuilder.success(
                        200,
                        "User created successfully",
                        response));
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request) {

        UserResponse updatedUser = userService.updateUser(id, request);

        return ResponseEntity.ok(
                ResponseBuilder.success(
                        200,
                        "User updated successfully",
                        updatedUser
                )
        );
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok(
                ResponseBuilder.successMessage(
                        200,
                        "User deleted successfully"
                )
        );
    }
}