package com.cenfotec.grupo4.gestor;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.IGestor;
import com.cenfotec.grupo4.utils.JsonManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class GestorProcess implements IGestor{
	
	private JsonManager jason;


	private ArrayList<Employee> employees;
	
	//Metodos para acceder al Json
	
	public ArrayList<Employee>fetchEmpleados() throws JsonParseException, JsonMappingException, IOException{
		return jason.fetchEmployees();
	}
	public ArrayList<Department> fetchDepartamentos() throws JsonParseException, JsonMappingException, IOException{
		return jason.fetchDepartments();
	}
	public String createJsonFromProcedure(Procedure procedure) throws JsonGenerationException, JsonMappingException, IOException {
		return jason.createJsonFromProcedure(procedure);
	}
	public Procedure createProcedureFromJsonString(String procedure) throws JsonGenerationException, JsonMappingException, IOException {
		return jason.createProcedureFromJsonString(procedure);
	}
	public void deleteFiles(String dir) {
		jason.deleteFiles(dir);
	}
	public void saveDpartments(ArrayList<Department> departamentos) throws JsonGenerationException, JsonMappingException, IOException {
		jason.saveDempartments(departamentos);
	}
	public void saveEmployees(ArrayList<Employee>empleados) throws JsonGenerationException, JsonMappingException, IOException {
		jason.saveEmployees(empleados);
	}
	
}
