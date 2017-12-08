package com.cenfotec.grupo4.utils;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

public class GestorCreate {

	private static Department departamento = new Department();
	private static Employee empleado = new Employee();
	private static  Procedure procedimento;
	private static Task caso = new Task();
	private static ObjectMapper mapeador = new ObjectMapper();
	private static GestorCreate instance;
	private void Gestor() {}
	public static GestorCreate getInstance() {
		if(instance != null) {
			synchronized (instance) {
				if(instance == null) {
					instance = new GestorCreate();
				}	
			}
		}
		return instance;
	}
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
	public static Procedure crearCaso(String startingDate,String finalDate,Task task,String procedureName) {
		return new Procedure(startingDate,finalDate,task,procedureName);	
	}
	public static Task crearTarea(String description,Task accepted,Task denied) {
		return new Task(null,"description");	
	}

}
