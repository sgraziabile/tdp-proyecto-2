package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Leer {
	
	private static String file = "ranking.txt";
	
	public static Jugador leer() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(Leer.file);
	    ObjectInputStream in = new ObjectInputStream(file);
	    Jugador jugador = (Jugador) in.readObject();
	    in.close();
	    file.close();
	    return jugador;
	}

}
