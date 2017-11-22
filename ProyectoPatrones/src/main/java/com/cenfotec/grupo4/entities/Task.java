package com.cenfotec.grupo4.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
	@JsonProperty
	private String description;
	@JsonProperty
	private boolean isFinal;
	@JsonProperty
	private TaskDesition desition;
	
	public Task() {
		
	}
	
	public Task(String description,boolean isFinal) {
		this.isFinal=isFinal;
		this.description=description;
		this.desition=TaskDesition.NoDesitionYet;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isFinal() {
		return isFinal;
	}
	
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
	
	public TaskDesition getDesition() {
		return desition;
	}
	
	public void setDesition(TaskDesition desition) {
		this.desition = desition;
	}
	
	public String toString() {
		String info ="---------------\n";
		info+="Desc: "+description+"\n";
		info+="Final task: "+isFinal+"\n";
		info+="Desition: "+desition+"\n";
		info+="---------------\n";
		return info;
	}
	
}
