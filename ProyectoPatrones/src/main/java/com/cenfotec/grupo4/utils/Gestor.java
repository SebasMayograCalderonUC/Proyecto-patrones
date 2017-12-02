package com.cenfotec.grupo4.utils;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

public class Gestor {

	private static Department departamento = new Department();
	private static Employee empleado = new Employee();
	private static  Procedure procedimento;
	private static Task caso = new Task();
	private static ObjectMapper mapeador = new ObjectMapper();
	
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
		return new Task(description,accepted,denied);	
	}

}
