package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Doctor;
import com.clinicmanagementsystem.cms.model.User;
import com.clinicmanagementsystem.cms.model.Worker;
import com.clinicmanagementsystem.cms.rest.repositories.DoctorRepository;
import com.clinicmanagementsystem.cms.rest.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class WorkerController {

    @Autowired
    WorkerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("worker")
    @ResponseBody
    public List<Worker> getWorkers(@Valid @RequestBody User user) {

        return repository.findAllByType("doctor");
    }
}
