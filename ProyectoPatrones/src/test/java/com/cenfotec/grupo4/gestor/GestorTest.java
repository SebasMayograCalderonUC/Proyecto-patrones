package com.cenfotec.grupo4.gestor;
import static org.junit.Assert.assertEquals;

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
	private static ArrayList<String> tareas;
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
		gestor.obtenerProcedimiento();
	}
	@Test
	public void enviarProcedimiento() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		 gestor.enviarProcedimiento(0, "IdDepartment");
	}
	@Test
	public void tratarProcedimiento() {
		 gestor.tratarProcedimiento(0, true);
	}
	@Test
	public void CrearProcedimiento() {
		gestor.CrearProcedimiento(tareas, "ProcedureTest");
	}
	@Test
	public void getAllActiveProcedures() {
		 gestor.getAllActiveProcedures();
	}
	@Test
	public void getAllFinalizedProcedures() {
		 gestor.getAllFinalizedProcedures();
	}
}
