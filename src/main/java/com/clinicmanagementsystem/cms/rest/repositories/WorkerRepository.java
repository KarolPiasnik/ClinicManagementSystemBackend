package com.clinicmanagementsystem.cms.rest.repositories;

import com.clinicmanagementsystem.cms.model.Doctor;
import com.clinicmanagementsystem.cms.model.User;
import com.clinicmanagementsystem.cms.model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "worker", path="worker" )
public interface WorkerRepository extends MongoRepository<Worker, String>{
    public Worker findByPesel(String pesel);
    public List<Worker> findAllByType(String type);

}
