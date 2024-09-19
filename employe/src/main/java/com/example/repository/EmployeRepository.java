package com.example.repository;

import com.example.entity.Employe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class EmployeRepository implements PanacheRepository<Employe> {
    public List<Employe> findByDepartementId(Long departementId) {
        return list("departementId", departementId);
    }
}
