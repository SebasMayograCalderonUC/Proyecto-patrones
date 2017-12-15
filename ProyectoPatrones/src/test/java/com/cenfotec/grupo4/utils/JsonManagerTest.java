package com.cenfotec.grupo4.utils;

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
import com.cenfotec.grupo4.entities.DepartmentTest;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.entities.Procedure;
import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.interfaces.use.StatusActive;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonManagerTest {
	private static JsonManager json;
	@BeforeClass
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		json = new JsonManager();
	}
	@Test
	public String createJsonFromProcedure() throws JsonGenerationException, JsonMappingException, IOException {
		return json.createJsonFromProcedure(ProcedureTest.procedure);
	}
	@Test
	public Department createDepartmentFromJson() throws JsonGenerationException, JsonMappingException, IOException {
		return json.createDepartmentFromJson("json");
	}
	@Test
	public String createJsonFromDepartment() throws JsonGenerationException, JsonMappingException, IOException {
		return json.createJsonFromDepartment(DepartmentTest.depart);
	}
	@Test
	public Procedure createProcedureFromJsonString() throws JsonParseException, JsonMappingException, IOException {
		return json.createProcedureFromJsonString("json");
	}
	@Test
	public ArrayList<Employee> fetchEmployees() throws JsonParseException, JsonMappingException, IOException{
		return json.fetchEmployees();
	}
	@Test
	public ArrayList<Department> fetchDepartments() throws JsonParseException, JsonMappingException, IOException{
		return json.fetchDepartments();
	}
	@Test
	public void deleteFiles() {
		json.deleteFiles("C:Dekstop");
	}
	@Test
	public void restoreFiles() throws JsonParseException, JsonMappingException, IOException{
		json.restoreFiles();
	}
	@Test
	public void saveDempartments() throws JsonGenerationException, JsonMappingException, IOException {
		json.saveDempartments(null);
	}
	@Test
	public void sevaEmployees() throws JsonGenerationException, JsonMappingException, IOException {
		json.saveEmployees(null);
	}
}
