package com.cenfotec.grupo4.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Employee {
	private static int cantEmployees=0;
	private String idEmployee;
	private String employeeFullName;
	private String job;
	private ArrayList<Procedure> treatedProcedures;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeFullName, String job) {
		this.employeeFullName = employeeFullName;
		this.job = job;
		cantEmployees++;
		this.idEmployee="EMP-"+cantEmployees;
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
}




















