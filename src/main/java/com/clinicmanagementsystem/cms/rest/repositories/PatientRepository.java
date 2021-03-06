package com.clinicmanagementsystem.cms.rest.repositories;

import com.clinicmanagementsystem.cms.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
public interface PatientRepository extends MongoRepository<Patient, String> {
    public Patient findByPesel(String pesel);

    public List<Patient> findAllByType(String type);

}
