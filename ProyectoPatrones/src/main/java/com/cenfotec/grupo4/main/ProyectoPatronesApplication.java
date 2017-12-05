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

import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;

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


    }

	
 }




















