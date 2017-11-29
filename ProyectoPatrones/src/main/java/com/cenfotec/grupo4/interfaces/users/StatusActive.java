package com.cenfotec.grupo4.interfaces.users;

import org.codehaus.jackson.annotate.JsonTypeName;

import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.IStatus;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonTypeName("Active")

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

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public String treatTask(Procedure procedure, boolean desition) {
		if(CheckTask(procedure)) {
			procedure.setCurrentTask(procedure.getCurrentTask().treatTast(desition));
			return "Procedure treated!";
		}else {
			return "Procedure has ended";
		}
	}

	@Override
	public boolean CheckTask(Procedure procedure) {
		if(procedure.getCurrentTask().getDeniedTask()==null && procedure.getCurrentTask().getAcceptedTask()==null) {
			procedure.setActualStatus(procedure.getFinalizedStatus());
			return false;
		}
		return true;
	}

}
