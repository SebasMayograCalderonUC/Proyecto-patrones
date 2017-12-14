package com.cenfotec.grupo4.gestor;


import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.interfaces.IGestor;
import com.cenfotec.grupo4.main.Login;
import com.cenfotec.grupo4.utils.JsonManager;
import com.cenfotec.grupo4.utils.SavingType;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;

public class GestorGeneral {
	
	private static GestorGeneral gest=null;
	private  ArrayList<Department> departments;
	public  String bla;
<<<<<<< HEAD
	private GestorGeneral() throws Exception {
=======
	GestorGeneral() throws JsonParseException, JsonMappingException, IOException {
>>>>>>> 322022c20eeb800262b21ad925d08843cb8931f9
		JsonManager jsonManager=new JsonManager();
		this.departments=jsonManager.fetchDepartments();
		Encryptor encryp=Encryptor.getInstance(SavingType.Symetric);
		for(Department dep:this.departments) {
			encryp.createKey(dep.getPrivatekey());
		}
	}
	public static GestorGeneral getInstance() throws Exception {
		if(gest==null) {
			gest=new GestorGeneral();
		}
		return gest;
	}
	public ArrayList<Department> getDepartments(){
		return departments;
	}
	
	public String obtenerProcedimiento() throws Exception {
		return Login.employee.obtainProcedure();
	}
	
	public String enviarProcedimiento(String procedureIndex,String departmentId) throws JsonGenerationException, JsonMappingException, IOException, Exception {
		Department departemnt=null;
		for(Department dep:departments) {
			if(dep.getIdDep().equals(departmentId)) {
				departemnt=dep;
			}
		}
		return Login.employee.sendProcedure(departemnt, procedureIndex);
	}
	
	public String tratarProcedimiento(int procedureIndex,boolean responce) {
		return Login.employee.treatProcedure(procedureIndex, responce);
	}
	
	public String CrearProcedimiento(ArrayList<String> tareas, String ProcedureName) {
		GestorCreate gestor =new GestorCreate();
		Login.employee.addProcedure(gestor.crearProcedure(tareas,ProcedureName));
		return "The procedure has been added";
	}
	
	public String getDepartmentsIDs() {
		String ids="---------------------------------\n";
		for(Department dep:this.departments) {
			ids+="id: "+dep.getIdDep()+"\n";
			ids+="---------------------------------\n";
		}
		return ids;
	}
	
	public String getAllActiveProcedures() {
		return Login.employee.getAllActiveProcedures();
	}
	public String getAllFinalizedProcedures() {
		return Login.employee.getAllFinalizedAProcedures();
	}
	
	
}
