package com.example.InsurTech.service.serviceImp;

import com.example.InsurTech.config.ResourceNotFoundException;
import com.example.InsurTech.dto.request.UserRequest;
import com.example.InsurTech.dto.response.UserResponse;
import com.example.InsurTech.enums.UserStatus;
import com.example.InsurTech.repository.UserRepository;
import com.example.InsurTech.service.service.UserService;
import com.example.InsurTech.util.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

//import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

import com.example.InsurTech.entity.User;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    // GET ALL
    @Override
    public PageResponse<UserResponse> getUsers(int page, int size, String search,  String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page - 1, size, sort);

        Page<User> userPage =
                userRepository.findByStatus(UserStatus.active, search, pageable );

        if (userPage.isEmpty()) {
            throw new ResourceNotFoundException("User not found!");
        }

        List<UserResponse> users = userPage.getContent()
                .stream()
                .map(this::mapToResponse)
                .toList();

        return PageResponse.of(users, userPage);
    }

    // GET BY ID
    @Override
    public UserResponse getUserById(Long id) {


        User user = userRepository.findByIdAndStatus(id, UserStatus.active)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        )
                );

        return mapToResponse(user);
    }

    //create
    @Override
    public UserResponse createUser(UserRequest request) {
        try {

            if (userRepository.existsByEmail(request.getEmail())) {
                throw new RuntimeException("Email already exists");
            }

            User user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setRole(request.getRole());
            user.setStatus(UserStatus.active);
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());

            User savedUser = userRepository.save(user);

            return mapToResponse(savedUser);

        } catch (RuntimeException e) {
            // rethrow known business exception
            throw e;

        } catch (Exception e) {
            // unexpected system error
            throw new RuntimeException("Error while creating user: " + e.getMessage());
        }
    }

    // UPDATE
    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        try{

            User user = userRepository.findByIdAndStatus(id, UserStatus.active)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setUpdatedAt(LocalDateTime.now());

            userRepository.save(user);

            return mapToResponse(user);

        } catch (RuntimeException e) {
            throw e;

        } catch (Exception e) {
            throw new RuntimeException("Error while updating user: " + e.getMessage());
        }
    }

    // DELETE
    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findByIdAndStatus(id, UserStatus.active)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        )
                );

        user.setStatus(UserStatus.inactive);

        userRepository.save(user);
    }

    // MAPPER
    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getStatus(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

}