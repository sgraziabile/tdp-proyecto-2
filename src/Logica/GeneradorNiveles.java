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
        
        ArrayList<String> lines = new ArrayList <String>();
        ArrayList<Entidad> entidades=new ArrayList<Entidad>();
        int width = 0;
        int height = 0;
        //Inicializamos el buffer de lectura.
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();//Guardamos la linea leida.
        while (line!=null) {
            //String 
             
            if (!line.startsWith("!")) {//El ! es usado para dejar comentarios en el txt por eso lo salteamos.
                lines.add(line);
                width = Math.max(width, line.length());

            }
            line = reader.readLine(); //Guardamos la nueva linea leida.
        }
        reader.close();//Cerramos el buffer de lectura
        height = lines.size();
        Tablero tablero=new Tablero(height);
        //Aclaracion: El Tablero siempre es de 30x30
        for (int j = 0; j < tablero.getTamanio(); j++) {
            line = lines.get(j);
            for (int i = 0; i < tablero.getTamanio(); i++) {
                if (i < line.length()) {
                    char ch = line.charAt(i);
                    /**
                     * La operacion que hacemos en el crear entidad es para quede en su correspondiente bloque la entidad.
                     * La multiplicacion por 20 se debe a que cada entidad mide 20x20 en coordenadas del JPanel, es decir
                     * 20 de ancho x 20 de alto, luego el +10 se usa para que queden centradas correctamente, ya que si no lo hacemos
                     * Cada entidad puede quedar en el medio de 4 bloques y no colisiona correctamente.
                     */
                    crearEntidad(i*20+10,j*20+10,ch,juego.getVentana(),entidades,tablero);
                }
                
            }
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
	private static Entidad crearEntidad(int i,int j,char entidadACrear,Ventana ventana,List<Entidad> entidades,Tablero tablero) {
		Entidad nueva=null;
		switch(entidadACrear){
			/*
			 * El ocupar en la pared se debe a que este bloque siempre tiene que estar mostrado por pantalla, de esta manera lo agregamos a 
			 * la lista de su respectivo bloque y lo mostramos, en cambio el las demas entidades son solo agregadas a la lista del bloque  
			 * pero no mostradas.
			 * El calculo matematico realizado en los getBloque es la inversa de lo explicado en el anterior metodo.
			 */
			case '#': nueva= new Pared(i,j,ventana);tablero.getBloque((i-10)/20, (j-10)/20).ocupar(nueva);break; 
			case 'm': nueva=new Manzana(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'b': nueva=new Banana(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'f': nueva=new Frutilla(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'u': nueva=new Uva(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'p': nueva=new Pera(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'a': nueva=new Azul(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'r': nueva=new Roja(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);nueva.getMiGrafica().getImage().setVisible(false);break;
			case 'v': nueva=new Verde(i,j,ventana);entidades.add(nueva);tablero.getBloque((i-10)/20, (j-10)/20).getEntidades().add(nueva);;nueva.getMiGrafica().getImage().setVisible(false);break;
			default :nueva=null;
		}
		return nueva;
		
	}
	
	
	
	

}
