package com.cenfotec.grupo4.command;

import com.cenfotec.grupo4.entities.*;
import com.cenfotec.grupo4.gestor.Gestor;
import com.cenfotec.grupo4.interfaces.ICommand;
import com.cenfotec.grupo4.utils.Gestor;

public class SendProcedure  implements ICommand{
	private Procedure procedure;
	private Department department;
	private Gestor gestor;
	public SendProcedure(Gestor pgestor,Procedure pProcedure, Department pDepartment) {
		procedure = pProcedure;
		department = pDepartment;
		gestor = pgestor;
		
	}
	@Override
	public void executar() {
		// TODO Auto-generated method stub
	}
	
}
