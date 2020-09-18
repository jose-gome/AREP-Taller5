package edu.escuelaing.arem.ASE.app;

import edu.escuelaing.arem.ASE.app.persistence.Conection;

public class HTTPServices {
	private Conection conexion; 
	public HTTPServices() {
		conexion = new Conection();
	}
	public String getData() {
		return conexion.consultarDatos(); 
	}
	public void insertar(String valor) {
		conexion.insertDataBase(valor);
	}
}
