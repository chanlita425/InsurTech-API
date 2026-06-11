package com.example.InsurTech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insurance_types")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String status;
}
