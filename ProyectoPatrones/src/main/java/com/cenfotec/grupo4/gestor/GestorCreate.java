package com.cenfotec.grupo4.gestor;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.interfaces.IGestor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;


public class GestorCreate implements IGestor{
	
	public Procedure crearProcedure(ArrayList<String>taskNames, String procedureName) {
		Date date = new Date();
		Procedure procedure=new Procedure(date.toString(),null,null,procedureName);
		for(String name:taskNames) {
			procedure.addTask(name);
		}
		return procedure;
	}
}
