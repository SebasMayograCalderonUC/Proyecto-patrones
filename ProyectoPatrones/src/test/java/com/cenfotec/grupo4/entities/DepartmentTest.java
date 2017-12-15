package com.cenfotec.grupo4.entities;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.suite.SuiteTests;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class DepartmentTest {
	public static Department depart;
	private static  Procedure procedure = new Procedure();
	private static ArrayList<Employee> empleados = new ArrayList<Employee>();
	private static ArrayList<String> receivedProcedure= new ArrayList<String>();
	private static ArrayList<Procedure> currentProcedures= new ArrayList<Procedure>();
	
	@BeforeClass
	public static void init() {
		depart = new Department("12345","67890",null,null,empleados,"Ventas");
	}
	
	@Test
	public void setAndGetCantiDep() {
		depart.setCantDep(1);
		assertEquals(1,depart.getCantDep());
	}
	@Test
	public void setAndGetidDep() {
		depart.setIdDep("id");
		assertEquals("id",depart.getIdDep());
	}
	@Test
	public void setAndeGetPublicKey() {
		depart.setPublicKey("key");
		assertEquals("key", depart.getPublicKey());
	}
	@Test
	public void setAndGetPrivateKey() {
		depart.setPrivatekey("privateKey");
		assertEquals("privateKey", depart.getPrivatekey());
	}
	@Test
	public void setAndGetReceivedProcedure() {
		depart.setRecivedProcedure(null);
		assertEquals(null, depart.getRecivedProcedure());
	}
	@Test
	public void setAndGetcurrentProcedure() {
		depart.setCurrentProcedures(null);
		assertEquals(null, depart.getCurrentProcedures());
	}
	@Test
	public void setAndGetEmployees() {
		depart.setEmployees(empleados);
		assertEquals(empleados,depart.getEmployees());
	}
	@Test
	public void setAndGetDepartmentName() {
		depart.setDepartmentName("Ventas");
		assertEquals("Ventas",depart.getDepartmentName());
	}
	@Test(expected=NullPointerException.class)
	public void obtainProcedure() throws Exception {
		 assertNotNull(depart.obtainProcedure());
	}
	@Test(expected=NullPointerException.class)
	public void sendProcedureToDepartment() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		 depart.sendProcedureToDepartment(null, null);
	}
	@Test
	public void recivedProcedure() {
		depart.recivedProcedure("procedureName");
	}
	@Test
	public void addEncriptedProcedure() {
		depart.addEncriptedProcedure("procedureName");
	}
}
