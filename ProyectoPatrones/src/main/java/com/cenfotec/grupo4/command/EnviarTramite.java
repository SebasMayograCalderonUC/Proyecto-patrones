package com.cenfotec.grupo4.command;

import com.cenfotec.grupo4.entities.*;
import com.cenfotec.grupo4.interfaces.ICommand;
import com.cenfotec.grupo4.utils.Gestor;

public class EnviarTramite  implements ICommand{
	private Procedure procedure;
	private Department department;
	private Gestor gestor;
	public EnviarTramite(Gestor pgestor,Procedure pProcedure, Department pDepartment) {
		procedure = pProcedure;
		department = pDepartment;
		gestor = pgestor;
		
	}
	@Override
	public void executar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean executar(Procedure pProcedure) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
