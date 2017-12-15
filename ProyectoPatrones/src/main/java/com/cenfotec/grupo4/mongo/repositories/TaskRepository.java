package com.cenfotec.grupo4.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.grupo4.entities.Task;

public interface TaskRepository extends MongoRepository<Task,String> {

}
