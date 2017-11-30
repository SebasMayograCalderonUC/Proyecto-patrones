package com.cenfotec.grupo4.interfaces;

public interface IEncryptManager {
	public String decryptMessage(String messageName, String keyName)throws Exception;
	public void createKey(String keyName)throws Exception;
	public void encryptMessage(String messageName, String message, String keyName)throws Exception;
}
