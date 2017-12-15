package com.cenfotec.grupo4.gestor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.suite.SuiteTests;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class GestorTest {
	
	public static GestorGeneral gestor;

	@Test(expected=UnrecognizedPropertyException.class)
	public void getInstance() throws Exception{
		assertEquals(gestor,gestor.getInstance());
	}
	@Test(expected=Exception.class)
	public void getDepartments(){
		assertEquals(null, gestor.getDepartments());
	}
	@Test(expected=NullPointerException.class)
	public void obtenerProcedimiento() throws Exception {
		assertEquals(null,gestor.obtenerProcedimiento());
	}
	@Test(expected=NullPointerException.class)
	public void enviarProcedimiento() throws JsonGenerationException, JsonMappingException, IOException, Exception {
		 assertEquals(null,gestor.enviarProcedimiento(1, "IdDepartment"));
	}
	@Test(expected=NullPointerException.class)
	public void tratarProcedimiento() {
		 assertEquals(null,gestor.tratarProcedimiento(0, true));
	}
	@Test(expected=NullPointerException.class)
	public void getAllActiveProcedures() {
		 assertNotNull(null,gestor.getAllActiveProcedures());
	}
	@Test(expected=NullPointerException.class)
	public void getAllFinalizedProcedures() {
		 assertEquals(null,gestor.getAllFinalizedProcedures());
	}
}
