package com.cenfotec.grupo4.utils;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

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

}
