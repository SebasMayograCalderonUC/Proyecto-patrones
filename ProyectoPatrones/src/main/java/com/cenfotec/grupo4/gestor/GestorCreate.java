package com.cenfotec.grupo4.gestor;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.IGestor;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

public class GestorCreate implements IGestor{

	public static Department crearDepartamento(String publicKey, String privatekey, ArrayList<String> recivedProcedures,
			ArrayList<Procedure> currentProcedures,ArrayList<Employee> employees,String departmentName) {
		return new Department(publicKey,privatekey,recivedProcedures,currentProcedures,employees,departmentName);
	}

	public static Procedure crearCaso(String startingDate,String finalDate,Task task,String procedureName) {
		return new Procedure(startingDate,finalDate,task,procedureName);	
	}
	public static Task crearTarea(String description,Task accepted,Task denied) {
		return new Task(null,"description");	
	}

}
