package com.cenfotec.grupo4.utils.encrypt;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;


import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.interfaces.IEncryptManager;
import com.cenfotec.grupo4.utils.JsonManager;
import com.cenfotec.grupo4.utils.SavingType;

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
	
	public String encrypt(Procedure procedure,Department department) throws JsonGenerationException, JsonMappingException, IOException, Exception {
		String json=jsonManager.createJsonFromProcedure(procedure);
		this.encryptManager.encryptMessage(procedure.getProcedureName(),json,department.getPrivatekey());
		return procedure.getProcedureName();
	}
	
	public Procedure decrypt(String procedureName,Department department) throws Exception {
		String json=encryptManager.decryptMessage(procedureName, department.getPrivatekey());
		return jsonManager.createProcedureFromJsonString(json);
	}
	public Encryptor() {
		// TODO Auto-generated constructor stub
	}
	
	

}



















