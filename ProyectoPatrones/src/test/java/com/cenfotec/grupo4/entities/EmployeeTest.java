package com.cenfotec.grupo4.entities;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
	private static Employee empleado;
	
	@BeforeClass
	public static void init() {
		empleado = new Employee("Marvin Calvo","Vendedor","mcalvo@gmail.com","mc420");
	}
	@Test
	public void setAndGetCantEmployees() {
		empleado.setCantEmployees(0);
		assertEquals(0,empleado.getCantEmployees());
	}
	@Test
	public void setAndGetIdEmployee() {
		empleado.setIdEmployee(null);
		assertEquals(null, empleado.getIdEmployee());
	}
	@Test
	public void setAndGetEmployeeFullName() {
		empleado.setEmployeeFullName(null);
		assertEquals(null, empleado.getEmployeeFullName());
	}
	@Test
	public void setAndGetJob() {
		empleado.setJob(null);
		assertEquals(null, empleado.getJob());
	}
	@Test
	public void setAndGettreatedProcedures() {
		empleado.setTreatedProcedures(null);
		assertEquals(null, empleado.getTreatedProcedures());
	}
	@Test
	public void setAndGettreatedPassword() {
		empleado.setPassword(null);
		assertEquals(null, empleado.getPassword());
	}
	@Test
	public void setAndGetEmail() {
		empleado.setEmail("email");
		assertEquals("email", empleado.getEmail());
	}
	@Test
	public String sendProcedure() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		return empleado.sendProcedure(null, 0);
	}
	@Test
	public String obteainProcedure() throws Exception {
		return empleado.obtainProcedure();
	}
	@Test
	public String getAllActiveProcedures() {
		return empleado.getAllActiveProcedures();
	}
	@Test
	public String getAllFinalizedAProcedures() {
		return empleado.getAllFinalizedAProcedures();
	}
	@Test
	public void setAndGetDepartment() {
		empleado.setDepartment(null);
		assertEquals(null, empleado.getDepartment());
	}
}
