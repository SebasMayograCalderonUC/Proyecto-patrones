package com.cenfotec.grupo4.entities;

import org.junit.BeforeClass;
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
}
