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
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.*;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;
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
		String filename = "time.ser";
        Employee emp = new Employee("Sebas", "Sistemas");
        ObjectMapper o=new ObjectMapper();
        String json= o.writeValueAsString(emp);
        System.out.println(json);
    }
		
	
	 
}
