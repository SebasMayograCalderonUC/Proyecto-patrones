package com.cenfotec.grupo4.main;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.gestor.GestorGeneral;

public class Login {
	public static Employee employee=null;
	
	public static boolean login(String email,String password) throws Exception {
		GestorGeneral gest = GestorGeneral.getInstance();
		ArrayList<Department>departments=gest.getDepartments();
	
		for(Department dep:departments) {
			
			for(Employee emp:dep.getEmployees()) {
				if(emp.getPassword().equals(password) && emp.getEmail().equals(email)) {
					employee=emp;
					return true;
				}
			}
		}
		return false;	
	}
	public static void logOut() {
		employee=null;
	}
}