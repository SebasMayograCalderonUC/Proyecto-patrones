package com.cenfotec.grupo4.entities;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	private static int cantEmployees=0;
	@JsonProperty
	private String idEmployee;
	@JsonProperty
	private String employeeFullName;
	@JsonProperty
	private String job;
	@JsonProperty
	private ArrayList<Procedure> treatedProcedures;
	@JsonIgnore
	private Department department;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeFullName, String job) {
		this.employeeFullName = employeeFullName;
		this.job = job;
		cantEmployees++;
		this.idEmployee="EMP-"+cantEmployees;
		this.treatedProcedures=new ArrayList<>();
	}

	public static int getCantEmployees() {
		return cantEmployees;
	}

	public static void setCantEmployees(int cantEmployees) {
		Employee.cantEmployees = cantEmployees;
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getEmployeeFullName() {
		return employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public ArrayList<Procedure> getTreatedProcedures(){
		return treatedProcedures;
	}
	
	public void setTreatedProcedures(ArrayList<Procedure> treatedProcedures) {
		this.treatedProcedures=treatedProcedures;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void obtainProcedure( ) {
		this.treatedProcedures.add(this.department.getCurrentProcedures().get(0));
		this.department.getCurrentProcedures().remove(0);
		
	}
	
}




















