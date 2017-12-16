package com.cenfotec.grupo4.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.mongo.repositories.TaskRepository;

@Service
public class TaskController {

	@Autowired
	private TaskRepository repo;
	
	public TaskController() {
		this.repo = MongoContextController.getContext().getBean("taskRepository",TaskRepository.class);
	}
	
	public void create(Task task) {
		repo.save(task);
	}
	
	public Task retrive(Task task) {
		//return repo.findOne(task());
		return null;
	}
	
	public List<Task> retriveAll() {
		return repo.findAll();
	}
	
	public void update(Task task) {
		repo.save(task);
	}
	
	public void delete(Task task) {
		//repo.delete(department.getIdDep());
	}
}
