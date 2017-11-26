package com.cenfotec.grupo4.interfaces.users;

import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.IStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusActive implements IStatus{
	@JsonProperty
	private String status;
	
	public StatusActive() {
		status="Active";
	}
	
	public String treatProcedure(Procedure procedure,boolean desition) {
		Task task=procedure.getCurrentTask();
		task=task.treatTast(desition);
		if(task==null) {
			changeProcedureStatus(procedure);
		}
		return "Task treated !";
	}

	
	public void changeProcedureStatus(Procedure procedure) {
		procedure.setActiveStatus(this);
		
	}
	
	public String getStatus() {
		return status;
	}
	public String treadTask(Task task,boolean desition,Procedure procedure) {
		task=task.treatTast(desition);
		if(task==null) {
			changeProcedureStatus(procedure);
		}
		return "Task treated !";
	}

}
