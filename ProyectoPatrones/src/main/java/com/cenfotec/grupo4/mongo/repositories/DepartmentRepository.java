package com.cenfotec.grupo4.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.grupo4.entities.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {

}
