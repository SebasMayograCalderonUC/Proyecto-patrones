package com.cenfotec.grupo4.entities;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cenfotec.grupo4.utils.SavingType;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;
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
		this.setEmployees(employees);
		this.publicKey = publicKey;
		this.privatekey = privatekey;
		this.recivedProcedure = new ArrayList<>();
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
	
	public synchronized Procedure obtainProcedure() throws Exception{
		if(this.recivedProcedure!=null) {
			decryptProcedures();
		}
		if(this.currentProcedures.size()==0) {
			return null;
		}
		Procedure procedure=this.currentProcedures.get(0);
		this.currentProcedures.remove(0);
		return procedure;
	}
	
	public void decryptProcedures() throws Exception {
		Encryptor encryptor=Encryptor.getInstance(SavingType.Asymetric);
		if(this.recivedProcedure.size()>=1) {
			while(this.recivedProcedure.get(0)!=null){
				this.currentProcedures.add(encryptor.decrypt(this.recivedProcedure.get(0), this));
				this.recivedProcedure.remove(0);	
			}
		}
		
	}
	
	public String sendProcedureToDepartment(Procedure procedure, Department department) throws JsonGenerationException, JsonMappingException, IOException, Exception {
		Encryptor encryptor=Encryptor.getInstance(SavingType.Asymetric);
		encryptor.encrypt(procedure, department);
		return "Procedure sended!!";
	}
	
	public void recivedProcedure(String procedureName) {
		if(this.recivedProcedure==null) {
			this.recivedProcedure=new ArrayList<>();
		}
		this.recivedProcedure.add(procedureName);
	}
	
	public void addEncriptedProcedure(String pricedureName) {
		this.recivedProcedure.add(pricedureName);
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
