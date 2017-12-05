package com.cenfotec.grupo4.gestor;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.utils.JsonManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Gestor {

	private static Department departamento = new Department();
	private static Employee empleado = new Employee();
	private static  Procedure procedimento;
	private static Task caso = new Task();
	private static ObjectMapper mapeador = new ObjectMapper();
	private static JsonManager jason;
	
	public static Task crearTarea() {
		return caso;
	}
	public static ObjectMapper Mapper() {
		return mapeador;
	}
	public static Department crearDepartamento(String publicKey, String privatekey, ArrayList<String> recivedProcedures,
			ArrayList<Procedure> currentProcedures,ArrayList<Employee> employees,String departmentName) {
		return new Department(publicKey,privatekey,recivedProcedures,currentProcedures,employees,departmentName);
	}
	public static Employee crearEmpleado(String employeeFullName, String job) {
		return new Employee(employeeFullName,job);
	}
	public static Procedure crearCaso(Date startingDate,Date finalDate,Task task,String procedureName) {
		return new Procedure(startingDate,finalDate,task,procedureName);	
	}
	public static Task crearTarea(String description,Task accepted,Task denied) {
		return new Task(null,"description");	
	}
	
	//Metodos para acceder al Json
	
	public static ArrayList<Employee>fetchEmpleados() throws JsonParseException, JsonMappingException, IOException{
		return jason.fetchEmployees();
	}
	public static ArrayList<Department> fetchDepartamentos() throws JsonParseException, JsonMappingException, IOException{
		return jason.fetchDepartments();
	}
	public static String createJsonFromProcedure(Procedure procedure) throws JsonGenerationException, JsonMappingException, IOException {
		return jason.createJsonFromProcedure(procedure);
	}
	public static Procedure createProcedureFromJsonString(String procedure) throws JsonGenerationException, JsonMappingException, IOException {
		return jason.createProcedureFromJsonString(procedure);
	}
	public static void deleteFiles(String dir) {
		jason.deleteFiles(dir);
	}
	public static void saveDpartments(ArrayList<Department> departamentos) throws JsonGenerationException, JsonMappingException, IOException {
		jason.saveDempartments(departamentos);
	}
	public static void saveEmployees(ArrayList<Employee>empleados) throws JsonGenerationException, JsonMappingException, IOException {
		jason.saveEmployees(empleados);
	}
	
}
