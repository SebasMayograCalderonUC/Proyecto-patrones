package com.cenfotec.grupo4.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.cenfotec.grupo4.entities.Procedure;

public class JsonManager {
	private  ObjectMapper objectMapper=new ObjectMapper();
	public  String createJsonFromProcedure(Procedure object) throws JsonGenerationException, JsonMappingException, IOException {
		return objectMapper.writeValueAsString(object);
	}
	public Procedure createProcedureFromJsonString(String json) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(json, Procedure.class);
	}
}
