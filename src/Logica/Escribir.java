package Logica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

public class Escribir {
	
	private static final String file = "ranking.txt";
	
	
	
	public static void guardar(Jugador[] ranking) throws Exception {
		try {
		FileOutputStream file = new FileOutputStream(Escribir.file);
		try {
	    ObjectOutputStream out = new ObjectOutputStream(file);
	    for(int i = 0; i < ranking.length; i++)
	    	try {
	    		out.writeObject(ranking[i]);
	    	} catch(NotSerializableException e) {
	    		e.printStackTrace();
	    	}
	    out.close();
	    file.close();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    } }catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
}
