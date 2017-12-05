package com.cenfotec.grupo4.command;

import com.cenfotec.grupo4.entities.*;
import com.cenfotec.grupo4.gestor.Gestor;
import com.cenfotec.grupo4.interfaces.ICommand;

public class TreatProcedure implements ICommand{
	private Gestor gestor;
	private int index;
	public TreatProcedure(Gestor pGestor, int pIndex) {
		gestor = pGestor;
		index = pIndex;
		
	}

	@Override
	public void executar() {
		gestor.toString();
	}

}
