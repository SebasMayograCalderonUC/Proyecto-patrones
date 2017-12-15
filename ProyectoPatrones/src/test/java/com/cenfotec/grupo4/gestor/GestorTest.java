package com.cenfotec.grupo4.gestor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.TaskTest;
import com.cenfotec.grupo4.suite.SuiteTests;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class GestorTest {
	private static GestorGeneral gestor;
	private static ArrayList<Department> departa;
	
	@BeforeClass
	public static void init() throws Exception {
		gestor = GestorGeneral.getInstance();
	}
	@Test
	public void getInstance() throws Exception{
		assertEquals(gestor,gestor.getInstance());
	}
	@Test
	public void getDepartments(){
		departa = gestor.getDepartments();
		assertEquals(departa, gestor.getDepartments());
	}
	@Test
	public void obtenerProcedimiento() throws Exception {
		assertEquals("",gestor.obtenerProcedimiento());
	}
	@Test
	public void enviarProcedimiento() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		 gestor.enviarProcedimiento(1, "IdDepartment");
	}
	@Test
	public void tratarProcedimiento() {
		 gestor.tratarProcedimiento(0, true);
	}
	@Test
	public void getAllActiveProcedures() {
		 assertNotNull("Viene nulo",gestor.getAllActiveProcedures());
	}
	@Test
	public void getAllFinalizedProcedures() {
		 assertEquals("",gestor.getAllFinalizedProcedures());
	}
}
