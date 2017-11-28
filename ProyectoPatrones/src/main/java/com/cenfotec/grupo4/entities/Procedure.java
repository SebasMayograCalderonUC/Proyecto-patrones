package com.cenfotec.grupo4.entities;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Date;

import com.cenfotec.grupo4.interfaces.IStatus;
import com.cenfotec.grupo4.interfaces.users.StatusActive;
import com.cenfotec.grupo4.interfaces.users.StatusFinalized;
import com.couchbase.client.core.annotations.InterfaceAudience.Public;

import org.codehaus.jackson.annotate.*;

public class Procedure {
	
	private static int cantProcedures=0;
	@JsonProperty
	private String idProcedure;
	@JsonProperty
	private Date startingDate;
	@JsonProperty
	private Date finalDate;
	@JsonProperty
	private Task currentTask;
	@JsonProperty
	private IStatus actualStatus;
	@JsonIgnore
	private StatusActive activeStatus;
	@JsonIgnore
	private StatusFinalized finalizedStatus;

	public Procedure() {
		this.activeStatus=new StatusActive();
		this.finalizedStatus= new StatusFinalized();
		this.actualStatus=activeStatus;
	}
	
	public Procedure(Date startingDate,Date finalDate,Task task) {
		cantProcedures++;
		this.idProcedure="PRO-"+cantProcedures;
		this.startingDate=startingDate;
		this.finalDate=finalDate;
		this.currentTask=task;
		activeStatus=new StatusActive();
		finalizedStatus= new StatusFinalized();
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
	public String treatProcedure(boolean desition) {
		String result=actualStatus.treatTask(this, desition);
		return result;
	}

	public IStatus getActualStatus() {
		return actualStatus;
	}

	public void setActualStatus(IStatus status) {
		this.actualStatus=status;
	}
	
}


























