package com.cenfotec.grupo4.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
import com.cenfotec.grupo4.utils.EncryptManagerSymetric;
import com.cenfotec.grupo4.utils.Encryptor;
import com.cenfotec.grupo4.utils.Gestor;
import com.cenfotec.grupo4.utils.JsonManager;

import org.apache.bsf.util.event.adapters.java_awt_event_ActionAdapter;
import org.codehaus.*;



import org.springframework.boot.autoconfigure.jackson.*;

import ch.qos.logback.core.net.ObjectWriter;

@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	
	public void run(String... args) throws Exception {
		JsonManager jsonManager=new JsonManager();
		ArrayList<Employee> employees= new ArrayList<Employee>();
		employees.add(new Employee("Sebastian Mayorga","Contabilidad"));
		employees.add(new Employee("Daniela Villalobos","Contabilidad"));
		employees.add(new Employee("Pablo Ramirez","Contabilidad"));
		employees.add(new Employee("Ignacio Rojas","Contabilidad"));
		
		
		Task taskHijoDer= new Task("Aprobacion de Beca", null, null);
		Task taskHijoIzq=new Task("Negacion de beca", null, null);
		Task taskPadre=new Task("Tramite de beca", taskHijoDer, taskHijoIzq);
		
		Task taskHijoDer2= new Task("Aprobacion de convalidacion", null, null);
		Task taskHijoIzq2=new Task("Negacion de convalidacion", null, null);
		Task taskPadre2=new Task("Convalidacion de Curso algebra", taskHijoDer2, taskHijoIzq2);
		
		Task taskHijoDer3= new Task("Aceptacion de matricula", null, null);
		Task taskHijoIzq3=new Task("Negacion de matricula", null, null);
		Task taskPadre3=new Task("Matricula estudiante", taskHijoDer3, taskHijoIzq3);
		ArrayList<Procedure>procedures=new ArrayList<Procedure>();
		procedures.add(new Procedure(null, null, taskPadre, "Tramite 1"));
		procedures.add(new Procedure(null, null, taskPadre2, "Tramite 2"));
		procedures.add(new Procedure(null, null, taskPadre3, "Tramite 3"));
		
		employees.get(0).setTreatedProcedures(procedures);
		
		Department department= new Department("clapaucios022", "krat56Los", null, procedures, employees,"Departamento de ");
		ArrayList<Department> departments=new ArrayList<Department>();
		departments.add(department);
		jsonManager.saveDempartments(departments);
		ArrayList<Department>departments=jsonManager.fetchDepartments();
		
		
			
    }
		
	
	 
}
