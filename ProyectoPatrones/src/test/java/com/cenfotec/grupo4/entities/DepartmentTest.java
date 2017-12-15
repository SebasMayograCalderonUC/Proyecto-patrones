package com.cenfotec.grupo4.entities;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {
	public static Department depart;
	private static Procedure procedure;
	@BeforeClass
	public static void init() {
		depart = new Department("12345","67890",null,null,null,"Ventas");
	}
	
	@Test
	public void setAndGetCantiDep() {
		depart.setCantDep(1);
		assertEquals(1,depart.getCantDep());
	}
	@Test
	public void setAndGetidDep() {
		depart.setIdDep("idDep");
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
		assertEquals("provateKey", depart.getPrivatekey());
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
		depart.setEmployees(null);
		assertEquals(null,depart.getEmployees());
	}
	@Test
	public void setAndGetDepartmentName() {
		depart.setDepartmentName("Ventas");
		assertEquals("Ventas",depart.getDepartmentName());
	}
	@Test
	public synchronized Procedure obtainProcedure() throws Exception {
		return depart.obtainProcedure();
	}
	@Test
	public void decryptedProcedures() throws Exception{
		depart.decryptProcedures();
	}
	@Test
	public String sendProcedureToDepartment() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		return depart.sendProcedureToDepartment(null, null);
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
