package com.cenfotec.grupo4.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cenfotec.grupo4.entities.*;
import com.cenfotec.grupo4.gestor.Action;

import com.cenfotec.grupo4.gestor.GestorGeneral;
import com.cenfotec.grupo4.utils.JsonManager;

import org.springframework.core.env.Environment;


@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {
	
	private static GestorGeneral gestorProcess;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		gestorProcess = GestorGeneral.getInstance();
		
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	
	public void run(String... args) throws Exception {
	
		int option;
		do {
			Login();
			ShowMessage("\n");
			ShowMessage("\n");
			ShowMessage("Controlador de Tramite  0.1");

			do {
	        	ShowMenu();
	        	option = GetInteger(CommunicationManager.CantOptions);
	        }while(!execMenu(option));
			ShowMessage("\n");
			ShowMessage("\n");
			ShowMessage("Controlador de Tramite  0.1");
	}while(Action.values()[option-1]!=Action.Exit);

    }
	
	public void Login() throws IOException {
		String [] datos=pedirDatosLogin();
		while(!Login.login(datos[0], datos[1])) {
			System.out.println("Contraseña o password incorrecta intente denuevo");
			datos=pedirDatosLogin();
		}
	
	}
	public String[] pedirDatosLogin() throws IOException {
		String[] datos=new String[2];
		System.out.println("Correo de usuario: ");
		datos[0]=br.readLine();
		System.out.println("Contraseña de usuario: ");
		datos[1]=br.readLine();
		return datos;
	}
	
	public boolean execMenu(int opcion) {
		
			switch (Action.values()[opcion-1]) {
			case CreateProcedure:
				
				break;
			case ObtainProcedure:
				
				break;
			case SendProcedure:
				
				break;
			case Logout:
					
				break;
			case Exit:
				
				break;
			case TreatProcedure:
				
				break;

			default:
				ShowMessage("Opcion invalida intente denuevo");
			}
		return false;
	}
	public void crearProcedimiento() {
		
	}
	public boolean Logout() {
		Login.logOut();
		return false;
	}
	
	public  int GetInteger(int limit) {
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
   public  boolean ValidateOption(int option,int limit) {
	   if(option>0 && option<=limit) {
		   return true;
	   }else {
		   return false;
	   }
   }
   public void ShowMenu() {
	   CommunicationManager communicationManager=new CommunicationManager();
	   communicationManager.ShowMenu();
   }
   public void ShowMessage(String message) {
	   CommunicationManager communicationManager=new CommunicationManager();
	   communicationManager.ShowMessage(message);
   }
   
}






















