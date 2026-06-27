package com.example.InsurTech.service.serviceImp;

import com.example.InsurTech.config.AuthException;
import com.example.InsurTech.dto.request.LoginRequest;
import com.example.InsurTech.entity.User;
import com.example.InsurTech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String login(LoginRequest request) {


        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() ->
                        new AuthException("Email not found!")
                );

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new AuthException("Password not found!");
        }

        return "Login successful";

    }
}