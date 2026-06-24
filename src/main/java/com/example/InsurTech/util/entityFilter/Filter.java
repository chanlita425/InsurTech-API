package com.example.InsurTech.util.entityFilter;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Filter {

    // pagination (1-based like frontend)
    private Integer page = 1;
    private Integer limit = 10;

    // sorting
    private String sortBy;
    private SortOrder sortOrder = SortOrder.ASC;

    // search
    private String search;

    // generic filters
    private String status;
    private String key;

    private String adm1Key;
    private String adm2Key;
    private String adm3Key;

    private Boolean isAdmin;
    private String userId;
}