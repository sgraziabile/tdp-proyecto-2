package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Leer {
	
	private static String file = "ranking.txt";
	
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
