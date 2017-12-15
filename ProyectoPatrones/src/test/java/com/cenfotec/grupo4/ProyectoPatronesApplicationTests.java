package com.cenfotec.grupo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenfotec.grupo4.suite.SuiteTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProyectoPatronesApplicationTests {

	@Test
	public void contextLoads() {
		SuiteTests test = new SuiteTests();
		
	}

}
