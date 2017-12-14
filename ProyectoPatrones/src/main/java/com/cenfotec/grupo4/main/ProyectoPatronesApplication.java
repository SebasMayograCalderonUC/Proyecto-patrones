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
			CommunicationManager.ShowMessage("\n");
			CommunicationManager.ShowMessage("\n");
			CommunicationManager.ShowMessage("Controlador de Tramite  0.1");

			do {
				CommunicationManager.ShowMenu();
	        	option = GetInteger(CommunicationManager.CantOptions);
	        }while(!execMenu(option));
			CommunicationManager.ShowMessage("\n");
			CommunicationManager.ShowMessage("\n");
			CommunicationManager.ShowMessage("Controlador de Tramite  0.1");
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
	
	public boolean execMenu(int opcion) throws Exception {
			switch (Action.values()[opcion-1]) {
			case CreateProcedure:
				CreateProcedure();
				break;
			case ObtainProcedure:
				ObtainProcedure();
				break;
			case SendProcedure:
				SendProcedure();
				break;
			case Logout:
				Logout();
				break;
			case Exit:
				Exit();
				break;
			case TreatProcedure:
				
				break;

			default:
				CommunicationManager.ShowMessage("Opcion invalida intente denuevo");
			}
		return false;
	}
	
	public void CreateProcedure() throws Exception {
		String nameProcedure =  CommunicationManager.AskForText("Ingrese el nombre del procedimiento");
		ArrayList<String> listNameTask = new ArrayList<String>();
		String value = "Sin descripcion";
		int i = 1;
		while(i!= -1) {
			value = CommunicationManager.AskForText("Ingrese la descripcion de la tarea numero " +i+"\n O -1 para continuar...");
			if(value.equals("-1")) {
				i = -1;
			}else {
				listNameTask.add(value);
				i++;
			}
		}
		CommunicationManager.ShowMessage(""+listNameTask.size());
		if(listNameTask.size() != 0) {
			this.gestorProcess.CrearProcedimiento(listNameTask,nameProcedure);
		}else {
			CommunicationManager.ShowMessage("Lo siento no se puede crear el procedimeinto");
		}
	}
	public void ObtainProcedure() throws Exception {
		String infoProcedure;
		infoProcedure = this.gestorProcess.obtenerProcedimiento();
		CommunicationManager.ShowMessageLine(infoProcedure);
	}
	public void SendProcedure() throws Exception {
		Employee employee = Login.employee;
		if(employee.getTreatedProcedures().size() == 0) {
			CommunicationManager.ShowMessage("");
			CommunicationManager.ShowMessage(employee.getEmployeeFullName()+" "+ "no tiene procediemientos\n"
			+ "Por favor obtenga uno de su Departamento");
			CommunicationManager.ShowMessage("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}else {
			int index = -1;
			int j = 0;
			String idProcedure ="";
			for(int i = 0; i<employee.getTreatedProcedures().size(); i++) {
				CommunicationManager.ShowMessage("");
				CommunicationManager.ShowMessage(employee.getTreatedProcedures().get(i).toString());
				CommunicationManager.ShowMessage("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			}
			idProcedure = CommunicationManager.AskForText("Ingrese el ID del Procedimeinto que dese tratar :");
			while(j<employee.getTreatedProcedures().size()) {
				if(employee.getTreatedProcedures().get(j).getIdProcedure().equals(idProcedure)) {
					index = j;;
				}
				j++;
			}
			String idDep = employee.getDepartment().getIdDep();
			gestorProcess.enviarProcedimiento(index,idDep);//Aqui se cae Sevas
		}
	}
	public boolean Logout() {
		Login.logOut();
		return false;
	}
	
	public void Exit() {
		System.exit(0);
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
			CommunicationManager.ShowMessageLine("Error try again: ");
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
}






















