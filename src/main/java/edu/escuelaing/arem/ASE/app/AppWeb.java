package edu.escuelaing.arem.ASE.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
/**
 * Calse encargada de crear la pagina web.
 * @author Jose Luis Gomez Camacho
 *
 */
public class AppWeb {
	/**
	 * Metodo encargado de hacer el llamado html, enviar y recibir datos. 
	 * @param args
	 */
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/public");
		post("/calculadora", (request, response) -> {
			
			Calculadora c = new Calculadora();
			c.leerJson(request.body());
			
			return "{\"media\":" + c.mean() + ", \"desviacion\":" + c.stddev() + "}";
		});
		
	}
	/**
	 * Metodo encargado de indicar el puerto por el que correra.
	 * @return Puerto a utilizar 
	 */
	public static int getPort(){
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}

}
