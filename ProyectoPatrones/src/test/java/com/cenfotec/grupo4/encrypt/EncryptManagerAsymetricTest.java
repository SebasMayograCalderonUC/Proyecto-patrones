package com.cenfotec.grupo4.encrypt;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.suite.SuiteTests;
import com.cenfotec.grupo4.utils.encrypt.EncryptManagerAsymetric;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class EncryptManagerAsymetricTest {
	public static EncryptManagerAsymetric encrypt;
	
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		encrypt = new EncryptManagerAsymetric();
	}
	@Test
	public void createKey() throws Exception {
		encrypt.createKey("Key");
	}
	@Test(expected=NullPointerException.class)
	public void saveToFile() throws IOException {
		encrypt.saveToFile(null, null, null);
	}

	@Test(expected=FileNotFoundException.class)
	public void decryptMessage() throws Exception {
		assertEquals("Message",encrypt.decryptMessage("Message","Key"));
	}
	@Test(expected=NullPointerException.class)
	public void writeBytesFile() throws FileNotFoundException, Exception {
		encrypt.writeBytesFile("Name",null,"Type");
	}
	@Test(expected=FileNotFoundException.class)
	public void readMessageFile() throws Exception{
		 assertEquals(null,encrypt.readMessageFile("Message"));
	}
}
