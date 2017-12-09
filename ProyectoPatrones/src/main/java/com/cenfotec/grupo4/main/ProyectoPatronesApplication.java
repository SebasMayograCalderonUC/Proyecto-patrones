package com.cenfotec.grupo4.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.Task;

import com.cenfotec.grupo4.gestor.GestorProcess;
import com.cenfotec.grupo4.interfaces.IGestor;
import com.cenfotec.grupo4.gestor.Action;
import com.cenfotec.grupo4.gestor.GestorCreate;
import com.cenfotec.grupo4.utils.encrypt.EncryptManagerSymetric;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;


import com.cenfotec.grupo4.utils.*;
import org.apache.bsf.util.event.adapters.java_awt_event_ActionAdapter;

import org.codehaus.*;
import org.springframework.boot.autoconfigure.jackson.*;
=======
import com.cenfotec.grupo4.gestor.Action;
import com.cenfotec.grupo4.gestor.GestorProcess;
import com.cenfotec.grupo4.utils.CaledarCustom;
import com.cenfotec.grupo4.utils.GestorCreate;
>>>>>>> 7080226515e93682625620068434144f4c2a300c
import org.springframework.core.env.Environment;


@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {
	
	private static IGestor gestorProcess;
	private static IGestor gestorCreate;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		gestorProcess = new GestorProcess();
		gestorCreate = new GestorCreate();
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	
	public void run(String... args) throws Exception {

		ShowMessage("\n");
		ShowMessage(new CaledarCustom().getFormattedDate());
		ShowMessage("\n");
		ShowMessage("Controlador de Tramite  0.1");
        int option;
		do {
        	ShowMenu();
        	option = GetInteger(CommunicationManager.CantOptions);
        }while(!execMenu(option));
		ShowMessage("\n");
		ShowMessage("\n");
    }
	
	public boolean execMenu(int opcion) {
		try {
			switch (Action.values()[opcion-1]) {
			case CreateProcedure:
				
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






















