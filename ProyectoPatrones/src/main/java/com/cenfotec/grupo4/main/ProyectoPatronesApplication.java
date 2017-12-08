package com.cenfotec.grupo4.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import com.cenfotec.grupo4.gestor.Action;
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
	private static Gestor  gestor;
	public static void main(String[] args) {
		gestor = Gestor.getInstance();
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	@Autowired
	private Environment env;
	@Autowired
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void run(String... args) throws Exception {
		System.out.println("\n");
		System.out.println("\n");
		ShowMessage("Controlador de Tramite  0.1");
        int option;
		do {
        	ShowMenu();
        	option = GetInteger(CommunicationManager.CantOptions);
        }while(!execMenu(option));
		System.out.println("\n");
		System.out.println("\n");

    }
	public boolean execMenu(int opcion) {
		try {
			switch (Action.values()[opcion-1]) {
			case CreateProcedure:
				gestor.
				break;
			case ObtainProcedure:
				
				break;
			case SendProcedure:
				
				break;
			case Exit:
				
				break;

			default:
				ShowMessage("Opcion invalida intente denuevo");
			}
			
		} catch (Exception e) {
			ShowMessage("Opcion invalida intente denuevo");
		}
		
		return false;
	}

	public static int GetInteger(int limit) {
	   int  option ;
	   do {   
		   try {
			   option = Integer.parseInt(br.readLine());
			   if(!ValidateOption(option,limit)) {
				//throw new Exception("error");
			   }
			   return option;
		   }catch (Exception e) {
			CommunicationManager communicationManager= new CommunicationManager();
			communicationManager.ShowMessageLine("Error try again: ");
		}	   
	   }while(true);
   }
   public static boolean ValidateOption(int option,int limit) {
	   if(option>0 && option<=limit) {
		   return true;
	   }else {
		   return false;
	   }
   }
   public static void ShowMenu() {
	   CommunicationManager communicationManager=new CommunicationManager();
	   communicationManager.ShowMenu();
   }
   
   public static void ShowMessage(String message) {
	   CommunicationManager communicationManager=new CommunicationManager();
	   communicationManager.ShowMessage(message);
   }
}


 

	





















