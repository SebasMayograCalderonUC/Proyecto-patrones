package com.cenfotec.grupo4.gestor;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.main.Login;

public class GestorGeneral {
	
	public static ArrayList<Department> departments;
	
	public String obtenerProcedimiento() throws Exception {
		return Login.employee.obtainProcedure();
	}
	
	public String enviarProcedimiento(int procedureIndex,String departmentId) throws JsonGenerationException, JsonMappingException, IOException, Exception {
		Department departemnt=null;
		for(Department dep:departments) {
			if(dep.getIdDep()==departmentId) {
				departemnt=dep;
			}
		}
		return Login.employee.sendProcedure(departemnt, procedureIndex);
	}
	
	public String tratarProcedimiento(int procedureIndex,boolean responce) {
		return Login.employee.treatProcedure(procedureIndex, responce);
	}
	
	public String getAllActiveProcedures() {
		return Login.employee.getAllActiveProcedures();
	}
	public String getAllFinalizedProcedures() {
		return Login.employee.getAllFinalizedAProcedures();
	}
	
}
