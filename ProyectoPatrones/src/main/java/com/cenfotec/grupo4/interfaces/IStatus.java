package com.cenfotec.grupo4.interfaces;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cenfotec.grupo4.entities.Procedure;
@JsonSerialize(as=IStatus.class)
public interface IStatus {
	public boolean treatProcedure(Procedure procedure);
	public void changeProcedureStatus(Procedure procedure);
}
