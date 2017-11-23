package com.cenfotec.grupo4.utils;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.omg.CORBA.NO_IMPLEMENT;

import com.cenfotec.grupo4.entities.Procedure;

public class Encryptor {
	private static Encryptor instance;
	private ObjectMapper objectMapper;
	private Encryptor() {
		objectMapper=new ObjectMapper();
	}
	public static Encryptor getInstance() {
		if(instance==null) {
			instance=new Encryptor();
		}
		return instance;
	}
	public String encrypProcedure(Procedure procedure) throws JsonGenerationException, JsonMappingException, IOException {
		String json=convertToJson(procedure);
		return json;
	}
	private String convertToJson(Procedure procedure) throws JsonGenerationException, JsonMappingException, IOException {
		String json=objectMapper.writeValueAsString(procedure);
		return json;
	}
	public Procedure decryptProcedure(String encriptedProcedure) throws JsonParseException, JsonMappingException, IOException {
		return parseFromJsonToProcedure(encriptedProcedure);
	}
	private Procedure parseFromJsonToProcedure(String JSON) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(JSON, Procedure.class);
	}
}


















