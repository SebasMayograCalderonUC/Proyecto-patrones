package com.cenfotec.grupo4.mongo.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongoContextController {

	private static ApplicationContext ctx;
	
	private MongoContextController() { 
		
	}
	
	public static ApplicationContext getContext() {
		
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		}
		
		return ctx;
		
	}
}
