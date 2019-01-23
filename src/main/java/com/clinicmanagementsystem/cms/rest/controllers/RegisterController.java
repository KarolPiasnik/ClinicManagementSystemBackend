package com.clinicmanagementsystem.cms.rest.controllers;

import com.clinicmanagementsystem.cms.exceptions.AlreadyActivatedException;
import com.clinicmanagementsystem.cms.model.User;
import com.clinicmanagementsystem.cms.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RegisterController {

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    @ResponseBody
    public User register(@Valid @RequestBody User user) {
        user.setId(null);
        user.setActive(Boolean.FALSE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }


    @GetMapping("register/{id}/activate")
    @ResponseBody
    public User activate(@PathVariable("id") String id) {
        User user = repository.findById(id).get();
        if (user != null) {
            if (!user.getActive()) {
                user.setActive(Boolean.TRUE);
            }
        } else {
            throw new DataRetrievalFailureException("The account that you try to activate no longer exists");
        }
        repository.save(user);
        return user;
    }

}
