package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entidades.*;
import GUI.Ventana;

public class GeneradorNiveles {
	
	/**
	 * Carga el nivel indicado y setea el tablero.
	 * @param filename Ruta del archivo de nivel.
	 * @param juego Juego donde se inicia.
	 * @return Lista de entidades del nivel(Alimento y Power Up).
	 * @throws IOException Si no encuentra el archivo.
	 */
	public static ArrayList<Entidad> cargarNivel(String filename,Juego juego) throws IOException {
        Tablero tablero=new Tablero(30);
        ArrayList lines = new ArrayList();
        ArrayList<Entidad> entidades=new ArrayList<Entidad>();
        int width = 0;
        int height = 0;
        //Inicializamos el buffer de lectura.
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            //Si no hay mas lineas para leer.
            if (line == null) {
                reader.close();
                break;
            }
            //Nos salteamos las lineas que empiecen 
            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());

            }
        }
        height = lines.size();

        for (int j = 0; j < 30; j++) {
            String line = (String) lines.get(j);
            for (int i = 0; i < width; i++) {
                if (i < line.length()) {
                    char ch = line.charAt(i);
                    Entidad e=crearEntidad(i,j,ch,juego.getVentana(),entidades);
                    if(e!=null ) {
                    	tablero.getBloque(i, j).ocupar(e);
                    }
                    
                }
                
            }
            System.out.println();
        }
        juego.setTablero(tablero);
        return entidades;

    }
	/**
	 * Crea una nueva entidad y la asigna a la lista de entidades.
	 * @param i Posicion x de la entidad.
	 * @param j Posicion y de la entidad.
	 * @param entidadACrear Caracter que denota cual entidad se va a crear.
	 * @param ventana Ventana del programa
	 * @param entidades Lista de entidades donde va a ser agregada
	 * @return La entidad creada.
	 */
	private static Entidad crearEntidad(int i,int j,char entidadACrear,Ventana ventana,List<Entidad> entidades) {
		Entidad nueva=null;
		switch(entidadACrear){
			case '#': nueva= new Pared(i,j,ventana);break; 
			case 'm': nueva=new Manzana(i,j,ventana);entidades.add(nueva);break;
			case 'b': nueva=new Banana(i,j,ventana);entidades.add(nueva);break;
			case 'f': nueva=new Frutilla(i,j,ventana);entidades.add(nueva);break;
			case 'u': nueva=new Uva(i,j,ventana);entidades.add(nueva);break;
			case 's': nueva=new Sandia(i,j,ventana);entidades.add(nueva);break;
			case 'a': nueva=new Azul(i,j,ventana);entidades.add(nueva);break;
			case 'r': nueva=new Roja(i,j,ventana);entidades.add(nueva);break;
			case 'v': nueva=new Verde(i,j,ventana);entidades.add(nueva);break;
			default :nueva=null;
		}
		return nueva;
		
	}
	
	
	
	

}
