package com.cenfotec.grupo4.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.grupo4.entities.Procedure;

public interface ProcedureRepository extends MongoRepository<Procedure,String> {

}
