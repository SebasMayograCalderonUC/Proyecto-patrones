package com.cenfotec.grupo4.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.mongo.repositories.ProcedureRepository;

@Service
public class ProcedureController {
	
	@Autowired
	private ProcedureRepository repo;
	
	public ProcedureController() {
		this.repo = MongoContextController.getContext().getBean("procedureRepository",ProcedureRepository.class);
	}
	
	public void create(Procedure procedure) {
		repo.save(procedure);
	}
	
	public Procedure retrive(Procedure procedure) {
		return repo.findOne(procedure.getIdProcedure());
	}
	
	public List<Procedure> retriveAll() {
		return repo.findAll();
	}
	
	public void update(Procedure procedure) {
		repo.save(procedure);
	}
	
	public void delete(Procedure procedure) {
		repo.delete(procedure.getIdProcedure());
	}
}
