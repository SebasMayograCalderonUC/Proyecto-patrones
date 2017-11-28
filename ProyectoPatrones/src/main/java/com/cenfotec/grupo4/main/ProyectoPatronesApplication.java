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
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;

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
	public void run(String... args) throws JsonGenerationException, JsonMappingException, IOException {
		
		Task task=new Task();
		Task task1=new Task();
		task1.setDescription("Hijo derecho");
		Task task_1=new Task();
		task_1.setDescription("Hijo izq");
		Task task12=new Task();
		task12.setDescription("Hijo derecho derecho");
		Task task1_2=new Task();
		task1_2.setDescription("hiijoi derecho izq");
		Task task_12=new Task();
		task_12.setDescription("hijo izq derecho");
		Task task_1_2=new Task();
		task_1_2.setDescription("Hijo izq izq");
		task.setDescription("Padre");
		task.setAcceptedTask(task1);
		task.setDeniedTask(task_1);
		task1.setAcceptedTask(task12);
		task1.setDeniedTask(task1_2);
		task_1.setAcceptedTask(task_12);
		task_1.setDeniedTask(task_1_2);
		Procedure procedure=new Procedure(null,null,task);
		System.out.println(procedure.treatProcedure(false));
		System.out.println(procedure.treatProcedure(true));
		System.out.println(procedure.getCurrentTask().getDescription());
		System.out.println(procedure.treatProcedure(true));
		System.out.println(procedure.treatProcedure(true));
		System.out.println(procedure.treatProcedure(true));
    }
		
	
	 
}
