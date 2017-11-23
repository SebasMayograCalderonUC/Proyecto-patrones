package com.cenfotec.grupo4.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Procedure;

public class MessageManager {
	public void sendProcedure(Department A, Department B, Procedure procedure) 
			throws JsonGenerationException, JsonMappingException, IOException {
		Encryptor encryptor=Encryptor.getInstance();
		encryptor.encrypProcedure(procedure);
		
	}
}
