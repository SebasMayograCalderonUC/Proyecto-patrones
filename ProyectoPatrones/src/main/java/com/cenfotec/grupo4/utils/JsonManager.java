package com.cenfotec.grupo4.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;

public class JsonManager {
	
	private  ObjectMapper objectMapper=new ObjectMapper();
	
	public  String createJsonFromProcedure(Procedure object) throws JsonGenerationException, JsonMappingException, IOException {
		return objectMapper.writeValueAsString(object);
	}
	
	public Procedure createProcedureFromJsonString(String json) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(json, Procedure.class);
	}
	
	public ArrayList<Employee> fetchEmployees() throws JsonParseException, JsonMappingException, IOException{
		File file= new File("../data/Employees");
		File[] jsons= file.listFiles();
		ArrayList<Employee>employees=new ArrayList<Employee>();
		for(int i =0;i<jsons.length;i++) {
			employees.add(objectMapper.readValue(jsons[i], Employee.class));
		}
		return employees;
	}
	
	public ArrayList<Department> fetchDepartments() throws JsonParseException, JsonMappingException, IOException{
		File file= new File("../data/Department");
		File[] jsons= file.listFiles();
		ArrayList<Department>departments=new ArrayList<Department>();
		for(int i =0;i<jsons.length;i++) {
			System.out.print(i);
			departments.add(objectMapper.readValue(jsons[i], Department.class));
		}
		return departments;
	}
	
	public void deleteFiles(String dir) {
		File directory=new File(dir);
		File[] filesTodelete=directory.listFiles();
		for(File file:filesTodelete) {
			file.delete();
		}
	}
	
	public void saveDempartments(ArrayList<Department>departments) throws JsonGenerationException, JsonMappingException, IOException {
		deleteFiles("../data/Department");
		for(int i=0;i<departments.size();i++) {
			objectMapper.writeValue(new File("../data/Department/dep"+i+".json"), departments.get(i));
		}
	}
	
	public void saveEmployees(ArrayList<Employee>employees) throws JsonGenerationException, JsonMappingException, IOException {
		deleteFiles("../data/Employees");
		for(int i=0;i<employees.size();i++) {
			objectMapper.writeValue(new File("../data/Employees/emp"+i+".json"), employees.get(i));
		}
	}
	
}
