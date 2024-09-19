package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DepartementDto {
    private Long id;
    private String nom;
    private boolean isOrganisationless;
    private Long organisationId;

}
