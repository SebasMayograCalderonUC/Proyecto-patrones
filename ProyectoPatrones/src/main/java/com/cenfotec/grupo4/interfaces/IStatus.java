package com.cenfotec.grupo4.interfaces;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cenfotec.grupo4.entities.Procedure;
@JsonSerialize
public interface IStatus {
	public String treatProcedure(Procedure procedure,boolean desition);
	public void changeProcedureStatus(Procedure procedure);
}
