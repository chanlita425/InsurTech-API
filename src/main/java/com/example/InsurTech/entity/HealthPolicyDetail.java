package com.example.InsurTech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "health_policy_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthPolicyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_type", length = 10)
    private String bloodType;

    @Column(name = "hospital_name", length = 255)
    private String hospitalName;

    @Column(name = "pre_existing_conditions", columnDefinition = "TEXT")
    private String preExistingConditions;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private Policy policy;


    @Column(name = "emergency_contact", length = 100)
    private String emergencyContact;
}

