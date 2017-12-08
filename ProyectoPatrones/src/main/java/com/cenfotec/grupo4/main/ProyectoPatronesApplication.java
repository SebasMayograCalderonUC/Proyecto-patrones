package com.cenfotec.grupo4.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cenfotec.grupo4.gestor.Action;
import com.cenfotec.grupo4.gestor.GestorProcess;
import com.cenfotec.grupo4.utils.CaledarCustom;
import com.cenfotec.grupo4.utils.GestorCreate;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {
	private static GestorProcess  gestorProcess;
	private static GestorCreate  gestorCreate;
	public static void main(String[] args) {
		gestorProcess = GestorProcess.getInstance();
		gestorCreate = GestorCreate.getInstance();
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	@Autowired
	private Environment env;
	@Autowired
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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






















