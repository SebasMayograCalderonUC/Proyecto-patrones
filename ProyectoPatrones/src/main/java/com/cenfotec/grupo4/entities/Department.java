package com.cenfotec.grupo4.entities;

import java.util.ArrayList;

public class Department {
	private static int cantDep=0;
	private String idDep;
	private String publicKey;
	private String privatekey;
	private String recivedProcedure;
	private boolean hasProcedureEncripted;
	private ArrayList<Procedure> currentProcedures;
	private ArrayList<Employee> employees;
	public Department(String publicKey, String privatekey, String recivedProcedures,
			ArrayList<Procedure> currentProcedures,ArrayList<Employee> employees) {
		cantDep++;
		this.idDep="DEP-"+cantDep;
		this.employees=employees;
		this.publicKey = publicKey;
		this.privatekey = privatekey;
		this.recivedProcedure = recivedProcedures;
		this.currentProcedures = currentProcedures;
		this.hasProcedureEncripted=false;
	}
	public Department() {
		
	}
	public static int getCantDep() {
		return cantDep;
	}
	public static void setCantDep(int cantDep) {
		Department.cantDep = cantDep;
	}
	public String getIdDep() {
		return idDep;
	}
	public void setIdDep(String idDep) {
		this.idDep = idDep;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	public String getRecivedProcedures() {
		return recivedProcedure;
	}
	public void setRecivedProcedures(String recivedProcedures) {
		this.recivedProcedure = recivedProcedures;
	}
	public ArrayList<Procedure> getCurrentProcedures() {
		return currentProcedures;
	}
	public void setCurrentProcedures(ArrayList<Procedure> currentProcedures) {
		this.currentProcedures = currentProcedures;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public boolean hasEncriptedProcedure() {
		return this.hasProcedureEncripted;
	}
	public void recivedProcedure(String procedureEncripted) {
		this.hasProcedureEncripted=true;
		this.recivedProcedure=procedureEncripted;
	}
	
	
	
	
	
}
