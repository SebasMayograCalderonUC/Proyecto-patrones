package com.cenfotec.grupo4.interfaces.users;

import org.codehaus.jackson.annotate.JsonTypeName;

import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.IStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonTypeName("Finalized")

public class StatusFinalized implements IStatus{
	@JsonProperty
	private String status;
	
	public StatusFinalized() {
		status="Finalized";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void changeProcedureStatus(Procedure procedure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String treatTask(Procedure procedure, boolean desition) {
		// TODO Auto-generated method stub
		return "Procedure has ended";
	}

	@Override
	public boolean CheckTask(Procedure procedure) {
		// TODO Auto-generated method stub
		return false;
	}

}
