package com.cenfotec.grupo4.gestor;


import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.main.Login;
import com.cenfotec.grupo4.utils.JsonManager;

public class GestorGeneral {
<<<<<<< HEAD
	
	private static GestorGeneral gest=null;
	private  ArrayList<Department> departments;
	public  String bla;
<<<<<<< HEAD
<<<<<<< HEAD
	private GestorGeneral() throws Exception {
=======
	GestorGeneral() throws JsonParseException, JsonMappingException, IOException {
>>>>>>> 322022c20eeb800262b21ad925d08843cb8931f9
=======
	private GestorGeneral() throws JsonParseException, JsonMappingException, IOException {
>>>>>>> parent of b381234... Fix encriptar
		JsonManager jsonManager=new JsonManager();
		this.departments=jsonManager.fetchDepartments();
		this.bla="Estoy aqui";
	}
	public static GestorGeneral getInstance() throws JsonParseException, JsonMappingException, IOException {
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
	
	public String CrearProcedimiento(ArrayList<String> tareas, String ProcedureName) {
		GestorCreate gestor =new GestorCreate();
		Login.employee.addProcedure(gestor.crearProcedure(tareas,ProcedureName));
		return "The procedure has been added";
	}
	
	public String getAllActiveProcedures() {
		return Login.employee.getAllActiveProcedures();
	}
	public String getAllFinalizedProcedures() {
		return Login.employee.getAllFinalizedAProcedures();
	}
	
}
=======
 
 private static GestorGeneral gest=null;
 private  ArrayList<Department> departments;
 public  String bla;
 GestorGeneral() throws JsonParseException, JsonMappingException, IOException {
  JsonManager jsonManager=new JsonManager();
  this.departments=jsonManager.fetchDepartments();
  this.bla="Estoy aqui";
 }
 public static GestorGeneral getInstance() throws JsonParseException, JsonMappingException, IOException {
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
 
 public String CrearProcedimiento(ArrayList<String> tareas, String ProcedureName) {
  GestorCreate gestor =new GestorCreate();
  Login.employee.addProcedure(gestor.crearProcedure(tareas,ProcedureName));
  return "The procedure has been added";
 }
 
 public String getAllActiveProcedures() {
  return Login.employee.getAllActiveProcedures();
 }
 public String getAllFinalizedProcedures() {
  return Login.employee.getAllFinalizedAProcedures();
 }
 
}
>>>>>>> Marvin
