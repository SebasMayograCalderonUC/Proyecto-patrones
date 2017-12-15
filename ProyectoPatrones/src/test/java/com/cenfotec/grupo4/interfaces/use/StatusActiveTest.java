package com.cenfotec.grupo4.interfaces.use;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.entities.SuiteTests;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
@SpringBootTest
public class StatusActiveTest {
	public static StatusActive status;
	
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		status = new StatusActive();
	}
	@Test(expected=NullPointerException.class)
	public void treatProcedure() {
		 status.treatProcedure(null, true);
	}
	
	@Test(expected=NullPointerException.class)
	public void changeProcedureStatus() {
		status.changeProcedureStatus(null);
	}
	@Test
	public void setAndGetStatus() {
		status.setStatus(null);
		assertEquals(null, status.getStatus());
	}
	@Test(expected=NullPointerException.class)
	public void treatTask() {
		 status.treatTask(null, true);
	}
	@Test(expected=NullPointerException.class)
	public void CheckTask() {
		 status.CheckTask(null);
	}
}
