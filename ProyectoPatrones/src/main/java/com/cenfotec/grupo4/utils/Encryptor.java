package com.cenfotec.grupo4.utils;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.interfaces.IEncryptManager;


public class Encryptor {
	private static Encryptor instance;
	private JsonManager jsonManager;
	private IEncryptManager encryptManager;

	private Encryptor(SavingType type) {
		jsonManager= new JsonManager();
		this.encryptManager=EncryptManagerFactory.EncryptorFactory(type);	
	}
	public static Encryptor getInstance(SavingType type) {
		if(instance==null) {
			instance=new Encryptor(type);
		}
		return instance;
	}
	public void createKey(String keyName) throws Exception {
		this.encryptManager.createKey(keyName);
	}
	public void encrypt(Procedure procedure,Department department) throws JsonGenerationException, JsonMappingException, IOException, Exception {
		String json=jsonManager.createJsonFromProcedure(procedure);
		this.encryptManager.encryptMessage(procedure.getProcedureName(),json,department.getPrivatekey());
	}
	public Procedure decrypt(String procedureName,Department department) throws Exception {
		String json=encryptManager.decryptMessage(procedureName, department.getPrivatekey());
		return jsonManager.createProcedureFromJsonString(json);
	}
	
	

}



















