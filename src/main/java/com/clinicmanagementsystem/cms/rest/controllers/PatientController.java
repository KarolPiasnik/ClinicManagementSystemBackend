package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Patient;
import com.clinicmanagementsystem.cms.rest.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
