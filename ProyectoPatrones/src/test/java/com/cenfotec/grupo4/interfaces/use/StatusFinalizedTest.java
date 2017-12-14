package com.cenfotec.grupo4.interfaces.use;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class StatusFinalizedTest {
	private static StatusFinalized status;
	
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		status = new StatusFinalized();
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
