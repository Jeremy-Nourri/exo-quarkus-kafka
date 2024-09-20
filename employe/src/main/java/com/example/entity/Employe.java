package com.example.entity;

import com.example.dto.DepartementDto;
import com.example.dto.OrganisationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employes")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int age;
    private String poste;

    @Column(name = "departement_id")
    private Long departementId;

    @Transient
    private DepartementDto departementDto;

    private boolean isDepartementless;

    @Column(name = "organisation_id")
    private Long organisationId;

    @Transient
    private OrganisationDto organisationDto;

}
