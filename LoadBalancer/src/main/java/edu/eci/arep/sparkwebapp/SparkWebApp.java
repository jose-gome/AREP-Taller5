package edu.eci.arep.sparkwebapp;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class SparkWebApp {
	 private static HTTPClient httpClient = new HTTPClient();

	 public static void main(String[] args) {
		 port(getPort());
	     staticFileLocation("/public");
	     post("/calculadora", (request, response) -> {
				httpClient.roundRobin();
				httpClient.postMessage(request.body(), "/calculadora");
				return "{\"media\":OK , \"desviacion\":OK}";
			});
			get("/registros", (request, response) -> {
				httpClient.roundRobin();
				return httpClient.getMessages("/registros");
			});
	     
	 }
	 public static int getPort() {
	        if (System.getenv("PORT") != null) {
	            return Integer.parseInt(System.getenv("PORT"));
	        }
	        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
	    }
}
