package com.cenfotec.grupo4.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.grupo4.entities.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
