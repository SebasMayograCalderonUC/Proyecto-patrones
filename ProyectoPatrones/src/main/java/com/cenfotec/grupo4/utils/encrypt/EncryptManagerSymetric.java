package com.cenfotec.grupo4.utils.encrypt;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.cenfotec.grupo4.interfaces.IEncryptManager;

public class EncryptManagerSymetric implements IEncryptManager{
	private final int KEYSIZE = 8;
	private final String KEY_EXTENSION = ".keySymet";
	private final String MESSAGE_ENCRYPT_EXTENSION = ".encriptSymet";
	private final String PATH = "../encrypt/symetric/";
	
	public void createKey(String keyName) throws Exception {
		byte [] key = generatedSequenceOfBytes();
		writeBytesFile(keyName,key,KEY_EXTENSION);
	}

	public void encryptMessage(String messageName, String message, String keyName) throws Exception {
		boolean salir=false;
		do {
			try {
				byte[] key = readKeyFile(keyName);
				Cipher cipher = Cipher.getInstance("AES");
				SecretKeySpec k = new SecretKeySpec(key,"AES");
				cipher.init(Cipher.ENCRYPT_MODE, k);
				byte[] encryptedData = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
			    Encoder oneEncoder = Base64.getEncoder();
			    encryptedData = oneEncoder.encode(encryptedData);
				writeBytesFile(messageName,encryptedData,MESSAGE_ENCRYPT_EXTENSION);
				salir=true;
			}catch(Exception ex) {
				createKey(keyName);
			}
		}while(!salir);	
	}
	
	public String decryptMessage(String messageName, String keyName) throws Exception {
		byte[] key = readKeyFile(keyName);
		byte[] encryptedMessage = readMessageFile(messageName);
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec k = new SecretKeySpec(key,"AES");
		cipher.init(Cipher.DECRYPT_MODE, k);
		byte[] DecryptedData = cipher.doFinal(encryptedMessage);
		String message = new String(DecryptedData, StandardCharsets.UTF_8);
		return message;
	}
	
	
	public void writeBytesFile(String name, byte[] content, String type) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(PATH + name + type);
		fos.write(content);
		fos.close();
	}
	
	private byte[] readKeyFile(String keyName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(PATH + keyName + KEY_EXTENSION));
		String everything = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} finally {
		    br.close();
		}
		return everything.getBytes(StandardCharsets.UTF_8);
	}
	
	public byte[] readMessageFile(String messageName) throws Exception{
		File file = new File(PATH + messageName + MESSAGE_ENCRYPT_EXTENSION);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        Decoder oneDecoder = Base64.getDecoder();
	    reader.close();
		return oneDecoder.decode(bytes);
	}

	private byte[] generatedSequenceOfBytes() throws Exception {
		StringBuilder randomkey = new StringBuilder();
		for (int i = 0;i < KEYSIZE;i++){
			randomkey.append(Integer.parseInt(Double.toString((Math.random()+0.1)*1000).substring(0,2)));
		}
		return randomkey.toString().getBytes("UTF-8");
	}

}
