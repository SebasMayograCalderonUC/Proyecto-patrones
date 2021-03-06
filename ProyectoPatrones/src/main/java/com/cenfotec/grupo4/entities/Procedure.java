package com.cenfotec.grupo4.entities;

import com.cenfotec.grupo4.interfaces.IStatus;
import com.cenfotec.grupo4.interfaces.use.StatusActive;
import com.cenfotec.grupo4.interfaces.use.StatusFinalized;
import org.codehaus.jackson.annotate.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Procedures")
public class Procedure {
	
	private static int cantProcedures=0;
	@JsonProperty
	@Id
	private String idProcedure;
	@JsonProperty
	private String procedureName;
	@JsonProperty
	private String startingDate;
	@JsonProperty
	private String finalDate;
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
	
	public Procedure(String startingDate,String finalDate,Task task,String procedureName) {
		cantProcedures++;
		this.idProcedure="PRO-"+cantProcedures;
		this.startingDate=startingDate;
		this.finalDate=finalDate;
		this.currentTask=task;
		this.procedureName=procedureName;
		activeStatus=new StatusActive();
		finalizedStatus= new StatusFinalized();
		actualStatus=activeStatus;	
	}
	
	public void addTask(String taskName) {
		if(currentTask==null) {
			currentTask = new Task(null,taskName);
		}else {
			currentTask.addTask(taskName);
		}
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

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String	finalDate) {

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

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	
	public String toString() {
		String info="Procedure ID: "+this.idProcedure+"\n";
		info+="Procedure Name: "+this.procedureName+"\n";
		info+="Procedure Starting date: "+this.startingDate+"\n";
		if(StatusFinalized.class.isInstance(this.actualStatus)) {	
			info+="Procedure Final date: "+this.finalDate+"\n";
		}else {
			info+="Procedure Current task: "+this.currentTask.getDescription()+"\n";
		}
		return info;
	}
	
	
}


























