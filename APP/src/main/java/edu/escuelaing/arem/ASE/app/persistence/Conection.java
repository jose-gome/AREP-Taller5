package edu.escuelaing.arem.ASE.app.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Conection {
	
	private MongoClientURI uri;
	private MongoCollection<org.bson.Document> columnas;
	private MongoClient mongoClient;

	public Conection() {	
		uri = new MongoClientURI(
				//arep-mongo-db2 localhost
				"mongodb://admin:Hola1234@arep-mongo-db2:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=ArepWebApp&authMechanism=SCRAM-SHA-256&3t.uriVersion=3");
		mongoClient = new MongoClient(uri);
		MongoDatabase dataBase = mongoClient.getDatabase("ArepWebApp");
		columnas = dataBase.getCollection("Registros");
	}
	
	public void insertDataBase(String valor) {
		Date fecha = new Date();
		Map<String, Object> document = new HashMap<String, Object>();
		document.put("Dato", valor );
		document.put("Fecha", fecha.toString());
		Document prueba = new Document(document);
		columnas.insertOne(prueba);
	}
	
	public String consultarDatos() {
		String data ="";
		int i=1;
		long total = columnas.countDocuments();
		for (Document d : columnas.find()) {
			if(i-1 > total- 10) {
				data += "Dato Numero " + String.valueOf(i)+" "+d.get("Dato").toString()+" "+d.get("Fecha").toString() + "\n";
			}
			i++;
		}
		return data; 
	}
}