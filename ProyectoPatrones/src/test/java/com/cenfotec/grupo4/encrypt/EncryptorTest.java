package com.cenfotec.grupo4.encrypt;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.entities.DepartmentTest;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.utils.SavingType;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptorTest {
	public static Encryptor encrypt;
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		encrypt = new Encryptor();
	}
	@Test
	public Encryptor getInstance() {
		return encrypt.getInstance(SavingType.Asymetric);
	}
	@Test
	public void createKey() throws Exception {
		encrypt.createKey("keyName");
	}
	@Test
	public String encrypt() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		return encrypt.encrypt(ProcedureTest.procedure, DepartmentTest.depart);
	}
	@Test
	public Procedure decrypt() throws Exception {
		return encrypt.decrypt(ProcedureTest.procedure.getProcedureName(), DepartmentTest.depart);
	}
	
}
