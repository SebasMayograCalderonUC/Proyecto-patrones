package com.cenfotec.grupo4.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.DepartmentTest;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.interfaces.use.StatusActive;
import com.cenfotec.grupo4.suite.SuiteTests;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SuiteTests.class})
public class JsonManagerTest {
	private static JsonManager json;
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		json = new JsonManager();
	}
	@Test
	public void createJsonFromProcedure() throws JsonGenerationException, JsonMappingException, IOException {
		json.createJsonFromProcedure(ProcedureTest.procedure);
	}
	@Test(expected=JsonParseException.class)
	public void createDepartmentFromJson() throws JsonGenerationException, JsonMappingException, IOException {
		assertEquals(DepartmentTest.depart,json.createDepartmentFromJson("json"));
	}
	@Test
	public void createJsonFromDepartment() throws JsonGenerationException, JsonMappingException, IOException {
		 json.createJsonFromDepartment(DepartmentTest.depart);
	}
	@Test(expected=JsonParseException.class)
	public void createProcedureFromJsonString() throws JsonParseException, JsonMappingException, IOException {
		json.createProcedureFromJsonString("json");
	}
	@Test(expected=NullPointerException.class)
	public void fetchEmployees() throws JsonParseException, JsonMappingException, IOException{
		assertEquals(DepartmentTest.depart.getEmployees(),json.fetchEmployees());
	}
	@Test(expected=UnrecognizedPropertyException.class)
	public void fetchDepartments() throws JsonParseException, JsonMappingException, IOException{
		assertEquals(null,json.fetchDepartments());
	}
	@Test
	public void restoreFiles() throws JsonParseException, JsonMappingException, IOException{
		json.restoreFiles();
	}
	@Test(expected=NullPointerException.class)
	public void saveDempartments() throws JsonGenerationException, JsonMappingException, IOException {
		json.saveDempartments(null);
	}
	@Test(expected=NullPointerException.class)
	public void saveEmployees() throws JsonGenerationException, JsonMappingException, IOException {
		json.saveEmployees(DepartmentTest.depart.getEmployees());
	}
}
