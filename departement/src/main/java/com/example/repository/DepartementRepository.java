package com.example.repository;

import com.example.entity.Departement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class DepartementRepository implements PanacheRepository<Departement> {
    public List<Departement> findByOrganisationId(Long organisationId) {
        return list("organisationId", organisationId);
    }
}
