package com.cenfotec.grupo4.gestor;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.entities.Department;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GestorTest {
	private static GestorGeneral gestor;
	
	@BeforeClass
	public static void init() throws Exception {
		gestor = new GestorGeneral();
	}
	
	@Test
	public static GestorGeneral getInstance() throws Exception {
		return gestor.getInstance();
	}
	@Test
	public ArrayList<Department> getDepartments(){
		return gestor.getDepartments();
	}
	@Test
	public String obtenerProcedimiento() throws Exception {
		return gestor.obtenerProcedimiento();
	}
	@Test
	public String enviarProcedimiento() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		return gestor.enviarProcedimiento(0, null);
	}
	@Test
	public String tratarProcedimiento() {
		return gestor.tratarProcedimiento(0, true);
	}
	@Test
	public String CrearProcedimiento() {
		return gestor.CrearProcedimiento(null, null);
	}
	@Test
	public String getAllActiveProcedures() {
		return gestor.getAllActiveProcedures();
	}
	@Test
	public String getAllFinalizedProcedures() {
		return gestor.getAllFinalizedProcedures();
	}
}
