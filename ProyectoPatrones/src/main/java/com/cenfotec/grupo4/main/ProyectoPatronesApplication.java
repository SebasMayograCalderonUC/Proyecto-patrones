package com.cenfotec.grupo4.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.*;
import org.mockito.internal.matchers.VarargCapturingMatcher;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.*;
import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
import com.cenfotec.grupo4.utils.Gestor;
import com.cenfotec.grupo4.utils.JsonManager;
import com.cenfotec.grupo4.utils.encrypt.EncryptManagerSymetric;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;

import org.apache.bsf.util.event.adapters.java_awt_event_ActionAdapter;

import org.codehaus.*;



import org.springframework.boot.autoconfigure.jackson.*;


@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
	
	public void run(String... args) throws Exception {
		ArrayList<Procedure> procedures=new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		dateFormat.format(date);
		Procedure procedureScolarshipOne=new Procedure(date.toString(),null, crearTask("Daniela villalobos"),
				"Procedimiento de beca Daniela villalobos Hasbum");
		procedures.add(procedureScolarshipOne);
		Procedure procedureScolarshipTwo=new Procedure(date.toString(),null, crearTask("Alejandro Mayorga"), 
				"Procedimiento de beca Alejandro Mayorga");
		procedures.add(procedureScolarshipTwo);
		Procedure procedureScolarshipThree=new Procedure(date.toString(),null, crearTask("Sebastian Mayorga"), 
				"Procedimiento de beca Sebastian Mayorga");
		procedures.add(procedureScolarshipThree);
		ArrayList<Employee>employees=new ArrayList<>();
		Employee sophie=new Employee("Sophia villalobos", "Decanatura");
		Employee Ale=new Employee("Ale villalobos", "Decanatura");
		employees.add(Ale);
		employees.add(sophie);
		Department department=new Department("llaveA", "llaveB", null, procedures, employees, "departamento decanatura");
		
	
		Ale.obtainProcedure();
		sophie.obtainProcedure();	
		JsonManager jsonManager=new JsonManager();
		String json=jsonManager.createJsonFromDepartment(department);
		Department department2=jsonManager.createDepartmentFromJson(json);
		
		System.out.println(department2.getEmployees().get(0).getTreatedProcedures().get(0).getProcedureName());
		
		
		
	
    }
	public Task crearTask(String nombre) {
		Task taskThirdSolarchip=new Task();
		taskThirdSolarchip.setDescription("Aprobacion de beca");
		Task taskSecondSolarchip=new Task(taskThirdSolarchip,"Aceptacion de requisitos");
		Task taskFirstSolarchip =new Task(taskSecondSolarchip,"Tarea inicial Beca "+nombre);
		return taskFirstSolarchip;
	}
		
	
	 
}
