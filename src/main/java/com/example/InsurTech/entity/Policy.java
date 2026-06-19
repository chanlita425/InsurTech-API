package com.example.InsurTech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "policies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "insurance_type_id", nullable = false)
    private Long insuranceTypeId;

    @Column(name = "policy_number", nullable = false, unique = true, length = 100)
    private String policyNumber;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "premium_amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal premiumAmount;

    @Column(name = "coverage_amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal coverageAmount;

    @Column(name = "issued_by")
    private Long issuedBy;

    @Column(length = 50)
    private String status;
}
