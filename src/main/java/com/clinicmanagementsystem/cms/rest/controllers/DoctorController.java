package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Doctor;
import com.clinicmanagementsystem.cms.rest.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DoctorController {

    @Autowired
    DoctorRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("doctor")
    @ResponseBody
    public List<Doctor> getDoctors() {
        return repository.findAllByType("doctor");
    }
}
