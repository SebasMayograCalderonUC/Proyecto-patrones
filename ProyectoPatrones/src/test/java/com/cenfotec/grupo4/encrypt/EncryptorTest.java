package com.cenfotec.grupo4.encrypt;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.entities.DepartmentTest;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.suite.SuiteTests;
import com.cenfotec.grupo4.utils.SavingType;
import com.cenfotec.grupo4.utils.encrypt.Encryptor;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class EncryptorTest {
	public static Encryptor encrypt;
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		encrypt = new Encryptor();
	}
	@Test(expected=AssertionError.class)
	public void getInstance() {
		 assertEquals(encrypt,encrypt.getInstance(SavingType.Asymetric));
	}
	@Test(expected=NullPointerException.class)
	public void createKey() throws Exception {
		encrypt.createKey("keyName");
	}
	@Test(expected=NullPointerException.class)
	public void encrypt() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		 assertEquals(ProcedureTest.procedure.getProcedureName(),encrypt.encrypt(ProcedureTest.procedure, DepartmentTest.depart));
	}
	@Test(expected=NullPointerException.class)
	public void decrypt() throws Exception {
		 assertEquals(ProcedureTest.procedure,encrypt.decrypt(ProcedureTest.procedure.getProcedureName(), DepartmentTest.depart));
	}
	
}
