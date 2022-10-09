package Logica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escribir {
	
	private static final String file = "ranking.txt";
	
	public static void guardar(Jugador jugador) throws FileNotFoundException, IOException{
		FileOutputStream file = new FileOutputStream(Escribir.file);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(jugador);
		out.close();
		file.close();
	}
}
