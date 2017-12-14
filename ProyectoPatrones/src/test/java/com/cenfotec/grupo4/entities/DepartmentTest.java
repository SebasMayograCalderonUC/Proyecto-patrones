package com.cenfotec.grupo4.entities;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {
	private static Department depart;
	
	@BeforeClass
	public static void init() {
		depart = new Department("12345","67890",null,null,null,"Ventas");
	}
	
}
