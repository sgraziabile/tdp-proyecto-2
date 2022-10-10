package Logica;

public class Ranking {
	
	protected Jugador[] arregloJugadores;
	
	public Ranking() {
		try {
			arregloJugadores = Leer.leer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Jugador[] getJugadores() {
		return arregloJugadores;
	}
	
	public void setRanking() {
		try {
			arregloJugadores = Leer.leer();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
						try {
						Escribir.guardar(arregloJugadores);
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
		}
}
	private void swap(int i, int j, Jugador newPlayer) {
		Jugador aux = arregloJugadores[j];
		arregloJugadores[j] = newPlayer;
		arregloJugadores[i] = aux;
	}
}