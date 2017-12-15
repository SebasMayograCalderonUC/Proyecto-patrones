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

import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.gestor.GestorGeneral;
import com.cenfotec.grupo4.suite.SuiteTests;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class StatusActiveTest {
	public static StatusActive status;
	
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		status = new StatusActive();
	}
	@Test
	public void treatProcedure() {
		status.treatProcedure(ProcedureTest.procedure, true);
	}
	@Test
	public void changeProcedureStatus() {
		status.changeProcedureStatus(ProcedureTest.procedure);
	}
	@Test
	public void setAndGetStatus() {
		status.setStatus("Active");
		assertEquals("Active", status.getStatus());
	}
	@Test
	public void treatTask() {
		status.treatTask(ProcedureTest.procedure, true);
	}
	@Test
	public void CheckTask() {
		status.CheckTask(ProcedureTest.procedure);
	}
}
