package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.model.Worker;
import com.clinicmanagementsystem.cms.rest.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WorkerController {

    @Autowired
    WorkerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("worker")
    @ResponseBody
    public List<Worker> getWorkers() {

        return repository.findAllByType("doctor");
    }
}
