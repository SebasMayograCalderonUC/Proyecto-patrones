package com.cenfotec.grupo4.entities;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;

import com.cenfotec.grupo4.interfaces.use.StatusActive;
import com.cenfotec.grupo4.interfaces.use.StatusFinalized;
import com.cenfotec.grupo4.utils.SavingType;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;
import com.couchbase.client.core.annotations.InterfaceAudience.Private;
import com.couchbase.client.core.annotations.InterfaceAudience.Public;
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
	@JsonProperty
	private String password;
	@JsonProperty
	private String email;
	
	@JsonIgnore
	private Department department;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeFullName, String job,String email,String password) {
		this.employeeFullName = employeeFullName;
		this.job = job;
		cantEmployees++;
		this.idEmployee="EMP-"+cantEmployees;
		this.treatedProcedures=new ArrayList<>();
		this.email=email;
		this.password=password;
	}

	public static int getCantEmployees() {
		return cantEmployees;
	}

	public static void setCantEmployees(int cantEmployees) {
		Employee.cantEmployees = cantEmployees;
	}
	
	public void addProcedure(Procedure procedure) {
		this.treatedProcedures.add(procedure);
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
	
	public String sendProcedure(Department departemnt,int procedureIndex) throws JsonGenerationException, JsonMappingException, IOException, Exception {
		Encryptor encryptor=Encryptor.getInstance(SavingType.Asymetric);
		String procedureName=encryptor.encrypt(this.treatedProcedures.get(procedureIndex), departemnt);
		return "Procedure has been send!!";
	}
	
	
	public String obtainProcedure( ) throws Exception {
		Procedure newprocedure=department.obtainProcedure();
		if(newprocedure==null) {
			return "there is no more procedures in this department \n eather wait to recive one or create one";
		}
		this.treatedProcedures.add(newprocedure);
		return "Procedure: "+treatedProcedures.get(treatedProcedures.size()-1).getProcedureName()+" recived!";	
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String treatProcedure(int procedureIndex,boolean responce) {
		return this.treatedProcedures.get(procedureIndex).treatProcedure(responce);
	}
	
	public String getAllActiveProcedures() {
		String info="--------------------------\n";
		for(Procedure procedure: this.treatedProcedures) {
			if(StatusActive.class.isInstance(procedure.getActualStatus())) {
				info=info+procedure.toString();
				info+="--------------------------\n";
			}
		}
		return info;
	}
	public String getAllFinalizedAProcedures() {
		String info="--------------------------\n";
		for(Procedure procedure: this.treatedProcedures) {
			if(StatusFinalized.class.isInstance(procedure.getActualStatus())) {
				info=info+procedure.toString();
				info+="--------------------------\n";
			}
		}
		return info;
	}
	
	
}




















