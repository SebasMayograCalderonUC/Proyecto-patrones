package com.cenfotec.grupo4.entities;

import java.util.ArrayList;
import java.util.Date;

import com.cenfotec.grupo4.interfaces.IStatus;
import com.cenfotec.grupo4.interfaces.users.StatusActive;
import com.cenfotec.grupo4.interfaces.users.StatusFinalized;
import com.fasterxml.jackson.annotation.*;

public class Procedure {
	
	private static int cantProcedures=0;
	@JsonProperty("idProcedure")
	private String idProcedure;
	@JsonProperty("startingDate")
	private Date startingDate;
	@JsonProperty("finalDate")
	private Date finalDate;
	@JsonProperty("tasks")
	private ArrayList<Task> tasks;
	@JsonProperty("currentTask")
	private Task currentTask;
	@JsonProperty("actualStatus")
	private IStatus actualStatus;
	@JsonIgnore
	private StatusActive activeStatus;
	@JsonIgnore
	private StatusFinalized finalizedStatus;

	
	public Procedure() {
		
	}
	
	public Procedure(Date startingDate,Date finalDate,ArrayList<Task> tasks) {
		cantProcedures++;
		this.idProcedure="PRO-"+cantProcedures;
		this.tasks=tasks;
		this.startingDate=startingDate;
		this.finalDate=finalDate;
		this.currentTask=this.tasks.get(0);
		activeStatus=new StatusActive();
		finalizedStatus= new StatusFinalized("Prueba 1");
		actualStatus=activeStatus;
	}

	public static int getCantProcedures() {
		return cantProcedures;
	}

	public static void setCantProcedures(int cantProcedures) {
		Procedure.cantProcedures = cantProcedures;
	}

	public String getIdProcedure() {
		return idProcedure;
	}

	public void setIdProcedure(String idProcedure) {
		this.idProcedure = idProcedure;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public StatusActive getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(StatusActive activeStatus) {
		this.activeStatus = activeStatus;
	}

	public StatusFinalized getFinalizedStatus() {
		return finalizedStatus;
	}

	public void setFinalizedStatus(StatusFinalized finalizedStatus) {
		this.finalizedStatus = finalizedStatus;
	}

	public IStatus getActualStatus() {
		return actualStatus;
	}

	public void setActualStatus(IStatus actualStatus) {
		this.actualStatus = actualStatus;
	}
	
	
	
}
