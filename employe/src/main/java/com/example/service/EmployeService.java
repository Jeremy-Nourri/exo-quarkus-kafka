package com.example.service;

import com.example.entity.Employe;
import com.example.repository.EmployeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class EmployeService {

    @Inject
    EmployeRepository employeRepository;
    @Inject
    EmployeEventProducer employeEventProducer;
    @Inject


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

    @Transactional
    public void delete(Long id) {
        Employe employe = employeRepository.findById(id);
        if (employe == null) {
            throw new IllegalArgumentException("No employe found for id: " + id);
        }
        employeRepository.delete(employe);
    }

    public Employe findById(Long id) {
        return employeRepository.findById(id);
    }

    public List<Employe> getAllEmployes() {
        return employeRepository.listAll();
    }

    public List<Employe> getEmployesByDepartementId(Long departementId) {
        return employeRepository.find("departementId", departementId).list();
    }

    public List<Employe> getEmployesByOrganisationId(Long organisationId) {
        return employeRepository.find("organisationId", organisationId).list();
    }





}
