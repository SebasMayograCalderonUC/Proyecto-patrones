package com.cenfotec.grupo4.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
	private static int cantDep=0;
	@JsonProperty
	private String idDep;
	@JsonProperty
	private String publicKey;
	@JsonProperty
	private String privatekey;
	@JsonProperty
	private ArrayList<String> recivedProcedure;
	@JsonProperty
	private ArrayList<Procedure> currentProcedures;
	@JsonProperty
	private ArrayList<Employee> employees;
	@JsonProperty
	private String departmentName;
	
	public Department(String publicKey, String privatekey, ArrayList<String> recivedProcedures,
			ArrayList<Procedure> currentProcedures,ArrayList<Employee> employees,String departmentName) {
		cantDep++;
		this.idDep="DEP-"+cantDep;
		this.publicKey = publicKey;
		this.privatekey = privatekey;
		this.recivedProcedure = recivedProcedures;
		this.currentProcedures = currentProcedures;
		this.departmentName=departmentName;
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
	
	public ArrayList<String> getRecivedProcedures() {
		return recivedProcedure;
	}
	
	public void setRecivedProcedures(ArrayList<String> recivedProcedures) {
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
		for(Employee employee: this.employees) {
			employee.setDepartment(this);
		}
	}

	public void recivedProcedure(String procedureName) {
		this.recivedProcedure.add(procedureName);
	}

	public ArrayList<String> getRecivedProcedure() {
		return recivedProcedure;
	}

	public void setRecivedProcedure(ArrayList<String> recivedProcedure) {
		this.recivedProcedure = recivedProcedure;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
