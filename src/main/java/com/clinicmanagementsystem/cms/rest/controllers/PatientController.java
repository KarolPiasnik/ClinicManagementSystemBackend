package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Patient;
import com.clinicmanagementsystem.cms.model.User;
import com.clinicmanagementsystem.cms.rest.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PatientController {

    @Autowired
    PatientRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("patient")
    @ResponseBody
    public List<Patient> getPatients() {
        return repository.findAllByType("patient");
    }

    @PostMapping("patient")
    @ResponseBody
    public Patient register(@Valid @RequestBody Patient patient) {
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        return repository.save(patient);
    }
}
