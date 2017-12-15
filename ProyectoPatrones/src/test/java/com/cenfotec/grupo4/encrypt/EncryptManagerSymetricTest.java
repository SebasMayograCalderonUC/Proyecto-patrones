package com.cenfotec.grupo4.encrypt;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptManagerSymetricTest {
	public static EncryptManagerSymetricTest encrypt;
	
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		encrypt = new EncryptManagerSymetricTest();
	}
	@Test
	public void createKey() {
		encrypt.createKey();
	}
	@Test
	public void saveToFile() {
		encrypt.saveToFile();
	}
	@Test
	public void encryptMessage() {
		encrypt.encryptMessage();
	}
	@Test
	public String decryptMessage() {
		return encrypt.decryptMessage();
	}
	@Test
	public void writeBytesFile() {
		encrypt.writeBytesFile();
	}
	@Test
	public byte[]readMessageFile(){
		return encrypt.readMessageFile();
	}
	
}
