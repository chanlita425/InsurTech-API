package com.example.InsurTech.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class VehiclePolicyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_type", length = 100)
    private String vehicleType;

    @Column(length = 100)
    private String brand;

    @Column(length = 100)
    private String model;

    @Column(name = "plate_number", length = 50, unique = true)
    private String plateNumber;

    @Column(name = "engine_number", length = 100)
    private String engineNumber;

    @Column(name = "chassis_number", length = 100)
    private String chassisNumber;

    @Column
    private Integer year;

    @Column(name = "vehicle_value", precision = 15, scale = 2)
    private BigDecimal vehicleValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private Policy policy;
}
