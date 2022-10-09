package Logica;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Ranking {
	
	protected Jugador[] arregloJugadores = new Jugador[5];
	
	public Jugador[] getJugadores() {
		return arregloJugadores;
	}
	
	public void agregarJugador(Jugador newPlayer) {
		int cont = 4;
		boolean establecido = false;
		int puntos = newPlayer.getPuntuacion();
		if(puntos >= arregloJugadores[cont].getPuntuacion()) {
			arregloJugadores[cont] = newPlayer;
			//ORDENAR
			while(cont > 0 && !establecido) {
				if(puntos >= arregloJugadores[cont - 1].getPuntuacion()) {
					swap(cont, cont - 1, newPlayer);
					cont--;
				}
				else
					establecido = true;
			}
			//SE PUEDE MOVER LA ESCRITURA AL MÉTODO SALIR() DE LA CLASE JUEGO
			for(int i = 0; i <= cont; i++) {
				try {
					Escribir.guardar(arregloJugadores[i]);
				} catch(FileNotFoundException e) { 
					System.out.println(e.getMessage());
				}
				  catch(IOException e) {
						System.out.println(e.getMessage());
				}
			}
		}
	}
	private void swap(int i, int j, Jugador newPlayer) {
		Jugador aux = arregloJugadores[j];
		arregloJugadores[j] = newPlayer;
		arregloJugadores[i] = aux;
	}
}
