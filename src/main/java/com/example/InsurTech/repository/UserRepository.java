package com.example.InsurTech.repository;

import com.example.InsurTech.entity.User;
import com.example.InsurTech.enums.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.status = :status")
    Optional<User> findByIdAndStatus(@Param("id") Long id, @Param("status") UserStatus status);

    @Query("SELECT u FROM User u WHERE u.status = 'active'")
    List<User> findAllActiveUsers();

    @Query("SELECT u FROM User u WHERE u.status = 'active'")
    Page<User> findAllActiveUsers(UserStatus status, Pageable pageable);

    @Query("""
        SELECT u FROM User u
        WHERE u.status = :status
        AND (
            :search IS NULL OR :search = ''
            OR LOWER(u.name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%'))
        )
    """)
    Page<User> findByStatus( @Param("status") UserStatus status,
                             @Param("search") String search,
                             Pageable pageable);

    //search


}
