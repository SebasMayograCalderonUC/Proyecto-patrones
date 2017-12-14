package com.cenfotec.grupo4.interfaces.use;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.gestor.GestorGeneral;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusActiveTest {
	private static StatusActive status;
	
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		status = new StatusActive();
	}
	@Test
	public String treatProcedure() {
		return status.treatProcedure(null, true);
	}
	@Test
	public void changeProcedureStatus() {
		status.changeProcedureStatus(null);
	}
	@Test
	public void setAndGetStatus() {
		status.setStatus(null);
		assertEquals(null, status.getStatus());
	}
	@Test
	public String treatTask() {
		return status.treatTask(null, true);
	}
	@Test
	public boolean CheckTask() {
		return status.CheckTask(null);
	}
}
