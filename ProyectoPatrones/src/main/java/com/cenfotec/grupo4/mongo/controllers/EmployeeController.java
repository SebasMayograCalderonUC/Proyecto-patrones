package com.cenfotec.grupo4.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.mongo.repositories.EmployeeRepository;

@Service
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	public EmployeeController() {
		this.repo = MongoContextController.getContext().getBean("employeeRepository",EmployeeRepository.class);
	}
	
	public void create(Employee employee) {
		repo.save(employee);
	}
	
	public Employee retrive(Employee employee) {
		return repo.findOne(employee.getIdEmployee());
	}
	
	public List<Employee> retriveAll() {
		return repo.findAll();
	}
	
	public void update(Employee employee) {
		repo.save(employee);
	}
	
	public void delete(Employee employee) {
		repo.delete(employee.getIdEmployee());
	}
}
