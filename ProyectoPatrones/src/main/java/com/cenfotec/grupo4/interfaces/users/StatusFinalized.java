package com.cenfotec.grupo4.interfaces.users;

import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.interfaces.IStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusFinalized implements IStatus{
	@JsonProperty
	private String status;
	
	public StatusFinalized() {
		status="Finalized";
	}
	public StatusFinalized(String status) {
		this.status=status;
	}
	@Override
	public boolean treatProcedure(Procedure procedure) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changeProcedureStatus(Procedure procedure) {
		// TODO Auto-generated method stub
		
	}

}
