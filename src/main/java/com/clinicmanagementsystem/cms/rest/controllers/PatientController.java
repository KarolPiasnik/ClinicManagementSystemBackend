package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Doctor;
import com.clinicmanagementsystem.cms.model.Patient;
import com.clinicmanagementsystem.cms.model.User;
import com.clinicmanagementsystem.cms.rest.repositories.DoctorRepository;
import com.clinicmanagementsystem.cms.rest.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PatientController {

    @Autowired
    PatientRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("doctor")
    @ResponseBody
    public List<Patient> getPatients(@Valid @RequestBody User user) {
        return repository.findAllByType("patient");
    }
}
