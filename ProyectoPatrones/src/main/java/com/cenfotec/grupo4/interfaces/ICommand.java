package com.cenfotec.grupo4.interfaces;

import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.utils.Gestor;

public interface ICommand {
	public void executar();
	public boolean  executar(Procedure pProcedure);

}
