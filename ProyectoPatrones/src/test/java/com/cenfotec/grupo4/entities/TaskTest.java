package com.cenfotec.grupo4.entities;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
	private static Task  task;
	@BeforeClass
	public static void init() {
		
		task = new Task(new Task(),"Esta es una tarea de prueba");
	}
	@Test
	public void testTreatTast(){
		assertEquals(task.getNextTask(),task.treatTast(true));
		assertEquals(null,task.treatTast(false));
	}
	@Test
	public void addTaskTest() {
		task.addTask("TaskTest");
		assertEquals("TaskTest",task.getNextTask().getDescription());
	}
	@Test
	public void setAndGetDescriptionTest() {
		task.setDescription("Nueva descripción");
		assertEquals("Nueva descripción",task.getDescription());
	}
	
}