package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrganisationDto {
    private Long id;
    private String nom;
    private String adresse;
    private int nombreSalarie;
    private String dateDerniereModification;
}
