package com.cenfotec.grupo4.data.mongobd;

import org.springframework.beans.factory.annotation.Autowired;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoAccess {

	@Autowired
	private static String conectionString = "mongodb://admin:abcd1234@ds133876.mlab.com:33876/patrones"; 
	private static MongoDatabase instance;
	
	private MongoAccess() {
		
	}
	
	public static MongoDatabase getConection() {
		
		if (instance == null) {
			MongoClientURI uri = new MongoClientURI(conectionString);
			MongoClient client = new MongoClient(uri);
			instance = client.getDatabase(uri.getDatabase());
		}		
		
		return instance;
	}
}
