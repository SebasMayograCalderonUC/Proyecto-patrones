package com.cenfotec.grupo4.ui;

import com.cenfotec.grupo4.gestor.GestorGeneral;
import com.cenfotec.grupo4.interfaces.use.EstrategiaGestor;
import com.cenfotec.grupo4.main.CommunicationManager;

public class ObtainProcedur implements EstrategiaGestor{
	GestorGeneral gestor ;
	public ObtainProcedur(GestorGeneral pgestor){
		this.gestor = pgestor;
	}
	@Override
	public void RunAction() throws Exception {
		String infoProcedure;
	
			infoProcedure = this.gestor.obtenerProcedimiento();
			CommunicationManager.ShowMessageLine(infoProcedure);
	
		
	}

}
