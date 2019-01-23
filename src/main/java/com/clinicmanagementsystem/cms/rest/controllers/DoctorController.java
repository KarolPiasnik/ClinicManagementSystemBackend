package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Doctor;
import com.clinicmanagementsystem.cms.model.Patient;
import com.clinicmanagementsystem.cms.rest.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("doctor")
    @ResponseBody
    public Doctor register(@Valid @RequestBody Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return repository.save(doctor);
    }
}
