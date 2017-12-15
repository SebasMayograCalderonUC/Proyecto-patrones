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
			CommunicationManager.ShowMessage("Processing controller 0.1");

			do {
				CommunicationManager.ShowMenu();
	        	option = GetInteger(CommunicationManager.CantOptions);
	        }while(!execMenu(option));
			CommunicationManager.ShowMessage("\n");
			CommunicationManager.ShowMessage("\n");
			CommunicationManager.ShowMessage("Processing controller 0.1");
	}while(Action.values()[option-1]!=Action.Exit);

    }
	
	public void Login() throws IOException {
		String [] datos=pedirDatosLogin();
		while(!Login.login(datos[0], datos[1])) {
			System.out.println("Incorrect password, try again");
			datos=pedirDatosLogin();
		}
	
	}
	public String[] pedirDatosLogin() throws IOException {
		String[] datos=new String[2];
		System.out.println("User mail: ");
		datos[0]=br.readLine();
		System.out.println("User password: ");
		datos[1]=br.readLine();
		return datos;
	}
	
	public boolean execMenu(int opcion) throws Exception {
			switch (Action.values()[opcion-1]) {
			case CreateProcedure:
				this.CreateProcedure();
				break;
			case ObtainProcedure:
				this.ObtainProcedure();
				break;
			case SendProcedure:
				this.SendProcedure();
				break;
			case TreatProcedure:
				this.TreatProcedure();
				break;
			case GetAllActiveProcedures:
				this.GetAllActiveProcedures();
				break;
			case GetAllFinalizedProcedures:
				this.GetAllFinalizedProcedures();
				break;
			case Logout:
				this.Logout();
				break;
			case Exit:
				this.Exit();
				break;
			

			default:
				CommunicationManager.ShowMessage("Invalid option try again");
			}
		return false;
	}
	public void CreateProcedure() throws Exception {
		String nameProcedure =  CommunicationManager.AskForText("Enter the name of the procedure");
		ArrayList<String> listNameTask = new ArrayList<String>();
		String value = "Sin descripcion";
		int i = 1;
		while(i!= -1) {
			value = CommunicationManager.AskForText("Enter the description of the task number " +i+"\n or  -1  to continue...");
			if(value.equals("-1")) {
				i = -1;
			}else {
				listNameTask.add(value);
				i++;
			}
		}
		CommunicationManager.ShowMessage(""+listNameTask.size());
		if(listNameTask.size() != 0) {
			CommunicationManager.ShowMessage(this.gestorProcess.CrearProcedimiento(listNameTask,nameProcedure));
		}else {
			CommunicationManager.ShowMessage("Sorry I can not create the procedure");
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
			CommunicationManager.ShowMessage(employee.getEmployeeFullName()+" "+ "does not have procedures.\n"
			+ "Please, get one from your Department or create one.");
			CommunicationManager.ShowMessage("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}else {
			int index;
			String idProcedure ="";
			this.MostrarProcedures(employee.getTreatedProcedures());
			idProcedure = CommunicationManager.AskForText("Enter the ID of the Procedure you want to treat :");
			index = getIndexProdedure(employee.getTreatedProcedures(),idProcedure);
			if(index >= 0) {
				String idDep = employee.getDepartment().getIdDep();
				CommunicationManager.ShowMessage(gestorProcess.enviarProcedimiento(index,idDep));//Aqui se cae Lavara
			}
		}
	}
	public void TreatProcedure() {
		Employee employee = Login.employee;
		int index;
		String idProcedure ="";
		this.MostrarProcedures(employee.getTreatedProcedures());
		idProcedure = CommunicationManager.AskForText("Enter the ID of the Procedure you want to treat:");
		index = getIndexProdedure(employee.getTreatedProcedures(),idProcedure);
		if(index >= 0) {
			boolean yesTreat = CheckProcedureTreatment();
			CommunicationManager.ShowMessage(this.gestorProcess.tratarProcedimiento(index,yesTreat));
		}
	}
	public boolean Logout(){
		Login.logOut();
		return false;
	}
	
	public void Exit() {
		System.exit(0);
	}
	private void MostrarProcedures(ArrayList<Procedure> pProcedure) {
		for(int i = 0; i<pProcedure.size(); i++) {
			CommunicationManager.ShowMessage("");
			CommunicationManager.ShowMessage(pProcedure.get(i).toString());
			CommunicationManager.ShowMessage("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
	}
	public void GetAllActiveProcedures() {
		CommunicationManager.ShowMessage(this.gestorProcess.getAllActiveProcedures());
	}
	public void GetAllFinalizedProcedures() {
		CommunicationManager.ShowMessage(this.gestorProcess.getAllFinalizedProcedures());
	}
	private int getIndexProdedure(ArrayList<Procedure> pProcedure,String idProcedure) {
		int index = -1;
		int j = 0;
		while(j<pProcedure.size()){
			if(pProcedure.get(j).getIdProcedure().equals(idProcedure)) {
				index = j;
			}
			j++;
		}
		return index;
	}

	private boolean CheckProcedureTreatment(){
		String value = "M";
		while(value !="1" && value !="2") {
			value = CommunicationManager.AskForText("1.Yes Treat Porceso \n2.No Treat Procedure\n");
			if(value.equals("1")) {
				return true;
			}
			if(value.equals("2")) {
				return false;
			}
		}
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






















