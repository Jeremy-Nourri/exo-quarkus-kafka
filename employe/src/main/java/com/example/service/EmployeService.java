package com.example.service;

import com.example.client.DepartementServiceClient;
import com.example.entity.Employe;
import com.example.repository.EmployeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class EmployeService {

    @Inject
    @RestClient
    DepartementServiceClient departementServiceClient;

    @Inject
    EmployeRepository employeRepository;

    @Transactional
    public Employe create(Employe employe) {
        if (employe == null) {
            throw new IllegalArgumentException("Employe cannot be null");
        }
        employeRepository.persist(employe);
        return employe;
    }

    @Transactional
    public Employe update(Employe employe) {
        if (employe == null) {
            throw new IllegalArgumentException("Employe cannot be null");
        }
        Employe existingEmploye = employeRepository.findById(employe.getId());
        if (existingEmploye == null) {
            throw new IllegalArgumentException("No employe found for id: " + employe.getId());
        }
        existingEmploye.setNom(employe.getNom());
        existingEmploye.setAge(employe.getAge());
        existingEmploye.setPoste(employe.getPoste());
        existingEmploye.setDepartementId(employe.getDepartementId());
        employeRepository.persist(existingEmploye);
        return existingEmploye;
    }



}
