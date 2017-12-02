package com.cenfotec.grupo4.entities;

import org.codehaus.jackson.annotate.*;

public class Task {
	
	@JsonProperty
	private String description;
	@JsonProperty
	private Task acceptedTask;
	@JsonProperty
	private Task deniedTask;
	
	public Task() {
		
	}
	
	public Task(String description,Task accepted,Task denied){
		this.acceptedTask=accepted;
		this.deniedTask=denied;
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Task getAcceptedTask() {
		return acceptedTask;
	}

	public void setAcceptedTask(Task acceptedTask) {
		this.acceptedTask = acceptedTask;
	}

	public Task getDeniedTask() {
		return deniedTask;
	}

	public void setDeniedTask(Task deniedTask) {
		this.deniedTask = deniedTask;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Task treatTast(boolean desition) {
		if(desition) {
			return this.acceptedTask;
		}
		return this.deniedTask;
	}
	

	public String toString() {
		String info ="---------------\n";
		info+="Desc: "+description+"\n";
		info+="---------------\n";
		return info;
	}
	
}
