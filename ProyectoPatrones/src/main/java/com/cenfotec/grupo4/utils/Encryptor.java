package com.cenfotec.grupo4.utils;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.codehaus.jackson.map.ObjectMapper;

public class Encryptor {
	private static Encryptor instance;
	private ObjectMapper objectMapper;
	private Encryptor() {
		objectMapper=new ObjectMapper();
	}
	public static Encryptor getInstance() {
		if(instance==null) {
			instance=new Encryptor();
		}
		return instance;
	}
}
