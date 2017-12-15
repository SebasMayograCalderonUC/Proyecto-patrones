package com.cenfotec.grupo4.entities;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.interfaces.use.StatusActiveTest;
import com.cenfotec.grupo4.interfaces.use.StatusFinalizedTest;
import com.cenfotec.grupo4.suite.SuiteTests;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class ProcedureTest {
	public static Procedure procedure;
	
	@BeforeClass
	public static void init() {
		procedure  = new Procedure("14/12/2017","20/12/2017",TaskTest.task,"Pocedimiento1");
	}
	
	@Test
	public void addTask() {
		procedure.addTask("TaskName");
	}
	@Test
	public void setAndGetCantProcedures() {
		procedure.setCantProcedures(0);
		assertEquals(0, procedure.getCantProcedures());
	}
	@Test
	public void setAndGetProcedureName() {
		procedure.setProcedureName("ProcedureName");
		assertEquals("ProcedureName", procedure.getProcedureName());
	}
	@Test
	public void setAndGetIdProcedure() {
		procedure.setIdProcedure("IdProcedure");
		assertEquals("IdProcedure",procedure.getIdProcedure());
	}
	@Test
	public void setAndGetStartingDate() {
		procedure.setStartingDate("05/3/2017");
		assertEquals("05/3/2017", procedure.getStartingDate());
	}
	@Test
	public void setAndGetfinalDate() {
		procedure.setFinalDate("25/3/2017");
		assertEquals("25/3/2017", procedure.getFinalDate());
	}
	@Test
	public void setAndGetCurrentTask() {
		procedure.setCurrentTask(TaskTest.task);
		assertEquals(TaskTest.task,procedure.getCurrentTask());
	}
	@Test
	public void setAndGetActualStatus() {
		procedure.setActualStatus(StatusActiveTest.status);
		assertEquals(StatusActiveTest.status, procedure.getActualStatus());
	}
	@Test
	public void setAndGetActivelStatus() {
		procedure.setActiveStatus(StatusActiveTest.status);
		assertEquals(StatusActiveTest.status, procedure.getActiveStatus());
	}
	@Test
	public void setAndGetFinalizedStatus() {
		procedure.setFinalizedStatus(StatusFinalizedTest.status);
		assertEquals(StatusFinalizedTest.status,procedure.getFinalizedStatus());
	}
}
