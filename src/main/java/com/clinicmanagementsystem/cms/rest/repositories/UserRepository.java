package com.clinicmanagementsystem.cms.rest.repositories;

import com.clinicmanagementsystem.cms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path="user" )
public interface UserRepository extends MongoRepository<User, String>{
    public List<User> findByLogin(String login);
    public List<User> findByEmail(String email);

}
