package com.example.InsurTech.service.service;

import com.example.InsurTech.dto.request.UserRequest;
import com.example.InsurTech.dto.response.UserResponse;
import com.example.InsurTech.util.PageResponse;
import com.example.InsurTech.util.entityFilter.Filter;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse createUser(UserRequest request);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);


}
