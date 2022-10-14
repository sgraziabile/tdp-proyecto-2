package Datos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import Logica.Jugador;

public class Leer {
	
	private static String file = "Datos\\ranking.txt";
	/*
	 * Lee el archivo seteado como atributo, crea un arreglo de 5 Jugadores y le asigna
	 * a cada posición del arreglo la instancia de un Jugador serializada en el archivo. 
	 */
	public static Jugador[] leer() throws Exception {
		FileInputStream file = new FileInputStream(Leer.file);
	    ObjectInputStream in = new ObjectInputStream(file);
	    Jugador[] ranking = new Jugador[5];
	    for(int i = 0; i < ranking.length; i++) {
	    	try {
	    	Jugador player = (Jugador) in.readObject();
	    	if(player != null)
	    		ranking[i] = player;
	    	} catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
	    }
	    in.close();
	    file.close();
	    return ranking;
	}
}
