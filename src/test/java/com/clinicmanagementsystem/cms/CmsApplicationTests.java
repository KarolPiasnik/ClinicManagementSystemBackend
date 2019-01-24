package com.clinicmanagementsystem.cms;

import com.clinicmanagementsystem.cms.model.User;
import com.clinicmanagementsystem.cms.rest.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsApplicationTests {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        User toDelete = repository.findByUsername("user111");
        if(toDelete != null){
          repository.delete(toDelete);
        }

        User testUser = new User();
        ObjectId objectId = new ObjectId();
        testUser.setId(objectId);
        testUser.setPassword(passwordEncoder.encode("password"));
        testUser.setActive(true);
        testUser.setEmail("kpiasnik11@pk.edu.pl");
        testUser.setEmailAddress("kpiasnik1@pk.edu.pl");
        testUser.setUsername("user111");
        repository.save(testUser);
        User returnedUser = repository.findByUsername("user111");

        assert returnedUser.getId().equals(testUser.getId());
    }

}
