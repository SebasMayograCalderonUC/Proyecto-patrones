package com.cenfotec.grupo4.interfaces;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.cenfotec.grupo4.entities.Procedure;

import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.use.StatusActive;
import com.cenfotec.grupo4.interfaces.use.StatusFinalized;


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
include=JsonTypeInfo.As.PROPERTY,
property="name")

@JsonSubTypes({
    @JsonSubTypes.Type(value=StatusActive.class, name="Active"),
    @JsonSubTypes.Type(value=StatusFinalized.class, name="Finalized"),
})
public interface IStatus {
	public String treatTask(Procedure procedure,boolean desition);
	public boolean CheckTask(Procedure procedure);
	public void changeProcedureStatus(Procedure procedure);
}
