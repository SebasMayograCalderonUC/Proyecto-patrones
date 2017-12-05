package com.cenfotec.grupo4.main;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.*;
import org.mockito.internal.matchers.VarargCapturingMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;

import com.cenfotec.grupo4.gestor.Gestor;
import com.cenfotec.grupo4.utils.JsonManager;
import com.cenfotec.grupo4.utils.encrypt.EncryptManagerSymetric;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;

import com.cenfotec.grupo4.utils.*;
import org.apache.bsf.util.event.adapters.java_awt_event_ActionAdapter;
import org.codehaus.*;



import org.springframework.boot.autoconfigure.jackson.*;
import org.springframework.core.env.Environment;
import org.springframework.data.annotation.CreatedBy;

import ch.qos.logback.core.net.ObjectWriter;

@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
	@Autowired
	private Environment env;

	public void run(String... args) throws Exception {
		JsonManager jsonManager=new JsonManager();
		jsonManager.saveDempartments(test());
		System.out.println("io e finito");
		
		
    }
	public ArrayList<Department> test() {
		String [] empleados=new String[3];
		String[] estudiantes=new String[3];
		empleados[0]="Daniela Vlillalobos";
		empleados[1]="Sophia Calderon";
		empleados[2]="Jimena Lobo";
		
		estudiantes[0]="Sebastian Mayorga";
		estudiantes[0]="Jimena Castro";
		estudiantes[0]="Alejandro Carvaja;";
		ArrayList<Department>departments=new ArrayList<>();
		departments.add(createDepartments(empleados, estudiantes, "Registro", "Matricula"));
		empleados[0]="Pablo Jimenez";
		empleados[1]="Valeria Merino";
		empleados[2]="Alex Mayorga";
		
		estudiantes[0]="Sebastian Corrales";
		estudiantes[0]="Alvaro Cordero";
		estudiantes[0]="Antonio Smith";
		departments.add(createDepartments(empleados, estudiantes, "Decanatura", "Convalidacion Calculo"));
		return departments;
		
	}
	public ArrayList<Employee> createEmployees(String[] nombres,String job){
		ArrayList<Employee>employees=new ArrayList<>();
		for(String nombre:nombres) {
			employees.add(new Employee(nombre,job));
		}
		return employees;
	}
	public Task createTask(String name,String taskname) {
		Task task2=new Task();
		task2.setDescription("Aprobacion de de"+taskname+" :"+name);
		Task task=new Task(task2,"Solicitud de"+taskname+" :"+name);
		return task;
	}
	
	public Procedure createProcedure(String name,String Taskname) {
		Task task=createTask(name,Taskname);
		Date date=new Date();
		Procedure procedure= new Procedure(date.toString(), null, task,"Matricula "+name);
		return procedure;
	}
	public Department createDepartments(String[] empleados,String[] estudiantes, String nombreDep,String taskName){
		ArrayList<Employee> employees=createEmployees(empleados, nombreDep);
		ArrayList<Procedure>procedures=new ArrayList<>();
		for(String estu:estudiantes) {
			procedures.add(createProcedure(estu,taskName));
		}
		Department department=new Department(nombreDep+"_key", nombreDep+"_-_key", null, procedures, null, nombreDep);
		department.setEmployees(employees);
		return department;
	}



}

















