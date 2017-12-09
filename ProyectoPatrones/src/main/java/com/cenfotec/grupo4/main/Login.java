package com.cenfotec.grupo4.main;

import java.util.ArrayList;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.gestor.GestorGeneral;

public class Login {
	
	public static Employee employee;
	
	public static boolean login(String email,String password) {
		ArrayList<Department>departments=GestorGeneral.departments;
		for(Department dep:departments) {
			if(employee!=null) {
				return true;
			}
			for(Employee emp:dep.getEmployees()) {
				if(emp.getEmail()==email &&emp.getPassword()==password) {
					employee=emp;
					return true;
				}
			}
		}
		return false;	
	}
	
}
