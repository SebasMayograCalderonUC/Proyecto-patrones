package com.cenfotec.grupo4.entities;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcedureTest {
	private static Procedure procedure;
	
	@BeforeClass
	public static void init() {
		procedure  = new Procedure("startingDate","finalDate",null,"procedureName");
	}
	
	@Test
	public void addTsk() {
		procedure.addTask(null);
	}
	
	@Test
	public void setAndGetCantProcedures() {
		procedure.setCantProcedures(0);
		assertEquals(0, procedure.getCantProcedures());
	}
	@Test
	public void setAndGetProcedureName() {
		procedure.setProcedureName(null);
		assertEquals(null, procedure.getProcedureName());
	}
	@Test
	public void setAndGetIdProcedure() {
		procedure.setIdProcedure(null);
		assertEquals(null,procedure.getIdProcedure());
	}
	@Test
	public void setAndGetStartingDate() {
		procedure.setStartingDate(null);
		assertEquals(null, procedure.getStartingDate());
	}
	@Test
	public void setAndGetfinalDate() {
		procedure.setFinalDate(null);
		assertEquals(null, procedure.getFinalDate());
	}
	@Test
	public void setAndGetCurrentTask() {
		procedure.setCurrentTask(null);
		assertEquals(null,procedure.getCurrentTask());
	}
	@Test
	public void setAndGetActualStatus() {
		procedure.setActualStatus(null);
		assertEquals(null, procedure.getActualStatus());
	}
	@Test
	public void setAndGetActivelStatus() {
		procedure.setActiveStatus(null);
		assertEquals(null, procedure.getActiveStatus());
	}
	@Test
	public void setAndGetFinalizedStatus() {
		procedure.setFinalizedStatus(null);
		assertEquals(null,procedure.getFinalizedStatus());
	}
}
