package com.example.InsurTech.repository;

import com.example.InsurTech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
