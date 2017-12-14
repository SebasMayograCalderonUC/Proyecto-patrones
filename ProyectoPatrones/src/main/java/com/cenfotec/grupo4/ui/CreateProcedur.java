package com.cenfotec.grupo4.ui;

import java.util.ArrayList;

import com.cenfotec.grupo4.gestor.GestorGeneral;
import com.cenfotec.grupo4.interfaces.use.EstrategiaGestor;
import com.cenfotec.grupo4.main.CommunicationManager;

public class CreateProcedur implements EstrategiaGestor{
	GestorGeneral gestor ;
	public CreateProcedur(GestorGeneral pgestor){
		this.gestor = pgestor;
	}
	@Override
	public void RunAction(){
		String nameProcedure =  CommunicationManager.AskForText("Ingrese el nombre del procedimiento");
		ArrayList<String> listNameTask = AskForHomework();
		CommunicationManager.ShowMessage(""+listNameTask.size());
		if(listNameTask.size() != 0) {
			this.gestor.CrearProcedimiento(listNameTask,nameProcedure);
		}else {
			CommunicationManager.ShowMessage("Lo siento no se puede crear el procedimeinto");
		}
		
	}
	private ArrayList<String> AskForHomework(){
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
		return listNameTask;
	}
}
