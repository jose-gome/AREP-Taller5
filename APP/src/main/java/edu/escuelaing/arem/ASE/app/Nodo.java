package edu.escuelaing.arem.ASE.app;
/**
 * Clase que representa los nodos del linked list
 * @author Jose
 */
public class Nodo {
	private Nodo next;
	private Object value;
	private int pos;
	/**
	 * Constructor del nodo.
	 * @param valor lo que va a almacenar el nodo. 
	 * @param unido nodo al que va a estar enlazado
	 * @param lugar Posicion del nodo en la lista
	 */
	public Nodo(Object valor, Nodo unido, int lugar) {
		value=valor;
		next=unido;
		pos= lugar;
	}
	/**
	 * M�todo encargado de unir el nodo con su vecino.
	 * @param cola Nodo con el que sera enlazado
	 */
	public void add(Nodo cola) {
		next= cola;
	}
	/**
	 * metodo encargado de comparar las posiciones
	 * @param posicion la posicion a comparar.
	 * @return Si es el nodo buscado
	 */
	public boolean setPos(int posicion) {
		return pos==posicion;
	}
	/**
	 * @return el valor del nodo. 
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @return retorna el nodo siguiente de el. 
	 */
	public Nodo getNext() {
		return next;
		
	}
}
