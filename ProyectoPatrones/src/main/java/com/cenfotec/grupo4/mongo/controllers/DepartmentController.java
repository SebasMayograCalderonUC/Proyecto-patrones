package com.cenfotec.grupo4.mongo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.mongo.repositories.DepartmentRepository;

@Service
public class DepartmentController {

	@Autowired
	private DepartmentRepository repo;
	
	public DepartmentController() {
		
		this.repo = MongoContextController.getContext().getBean("departmentRepository",DepartmentRepository.class);
	}
	
	public void create(Department department) {
		repo.save(department);
	}
	
	public Department retrive(Department department) {
		return repo.findOne(department.getIdDep());
	}
	
	public List<Department> retriveAll() {
		return repo.findAll();
	}
	
	public void update(Department department) {
		repo.save(department);
	}
	
	public void delete(Department department) {
		repo.delete(department.getIdDep());
	}
}
