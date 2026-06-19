package com.example.InsurTech.service.serviceImp;

import com.example.InsurTech.dto.request.UserRequest;
import com.example.InsurTech.dto.response.UserResponse;
import com.example.InsurTech.repository.UserRepository;
import com.example.InsurTech.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }

}
