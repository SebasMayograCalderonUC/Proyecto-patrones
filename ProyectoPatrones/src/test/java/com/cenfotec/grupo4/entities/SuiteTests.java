package com.cenfotec.grupo4.entities;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cenfotec.grupo4.gestor.GestorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TaskTest.class,
    DepartmentTest.class,
    EmployeeTest.class
})

public class SuiteTests {
	public SuiteTests() {
	
	}
}

