package com.cenfotec.grupo4.entities;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.suite.SuiteTests;

@RunWith(SpringRunner.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@ContextConfiguration(classes = {SuiteTests.class})
public class EmployeeTest {
	public static Employee empleado;
	
	
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
		empleado.setJob("Vendedor");
		assertEquals("Vendedor", empleado.getJob());
	}
	@Test
	public void setAndGettreatedProcedures() {
		empleado.setTreatedProcedures(null);
		assertEquals(null, empleado.getTreatedProcedures());
	}
	@Test
	public void setAndGettreatedPassword() {
		empleado.setPassword("pass");
		assertEquals("pass", empleado.getPassword());
	}
	@Test
	public void setAndGetEmail() {
		empleado.setEmail("email");
		assertEquals("email", empleado.getEmail());
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void sendProcedure() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		empleado.sendProcedure(null, 0);
	}
	@Test(expected=NullPointerException.class)
	public void obteainProcedure() throws Exception {
		empleado.obtainProcedure();
	}
	@Test(expected=NullPointerException.class)
	public void getAllActiveProcedures() {
		assertEquals(null,empleado.getAllActiveProcedures());
	}
	@Test
	public void getAllFinalizedAProcedures() {
		 empleado.getAllFinalizedAProcedures();
	}
	@Test
	public void setAndGetDepartment() {
		empleado.setDepartment(DepartmentTest.depart);
		assertEquals(DepartmentTest.depart, empleado.getDepartment());
	}
}
