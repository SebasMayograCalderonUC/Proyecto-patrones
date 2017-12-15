package com.cenfotec.grupo4.entities;

import org.codehaus.jackson.annotate.*;

public class Task {
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private Task nextTask;
	
	public Task() {
		
	}
	
	public Task(Task nextTask, String description) {
		this.nextTask=nextTask;
		this.description=description;
	}
	
	public Task treatTast(boolean desition) {
		if(desition) {
			return this.nextTask;
		}
		this.setNextTask(null);
		return this;
	}

	public Task getNextTask() {
		return nextTask;
	}
	
	public void setNextTask(Task nextTask) {
		this.nextTask = nextTask;
	}
	
	public void addTask(String taskName) {
		if(this.nextTask!=null) {
			this.nextTask.addTask(taskName);
		}else {
			this.nextTask=new Task(null,taskName);
		}
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		String info ="---------------\n";
		info+="Desc: "+description+"\n";
		info+="---------------\n";
		return info;
	}
	
}
