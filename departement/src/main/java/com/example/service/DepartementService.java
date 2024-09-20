package com.example.service;

import com.example.entity.Departement;
import com.example.repository.DepartementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class DepartementService {

    @Inject
    DepartementRepository departementRepository;

    @Transactional
    public Departement create(Departement departement) {
        if (departement == null) {
            throw new IllegalArgumentException("Departement cannot be null");
        }

        departementRepository.persist(departement);

        return departement;
    }

    @Transactional
    public Departement update(Departement departement) {
        if (departement == null) {
            throw new IllegalArgumentException("Departement cannot be null");
        }

        Departement existingDepartement = departementRepository.findById(departement.getId());

        if (existingDepartement == null) {
            throw new IllegalArgumentException("No departement found for id: " + departement.getId());
        }

        existingDepartement.setNom(departement.getNom());
        existingDepartement.setOrganisationId(departement.getOrganisationId());
        existingDepartement.setOrganisationless(departement.isOrganisationless());

        departementRepository.persist(existingDepartement);

        return existingDepartement;
    }


    public Departement findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Departement id cannot be null");
        }

        Departement departement = departementRepository.findById(id);

        if (departement == null) {
            throw new IllegalArgumentException("No departement found for id: " + id);
        }

        return departement;

    }

}
