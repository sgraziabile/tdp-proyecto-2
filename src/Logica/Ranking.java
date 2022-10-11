package Logica;

public class Ranking {
	
	protected Jugador[] arregloJugadores;
	
	public Ranking() {
		arregloJugadores = new Jugador[5];
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
		int cont = this.cantJugadores();
		int puntos = newPlayer.getPuntuacion();
		if(cont < this.getJugadores().length) {
			if(arregloJugadores[cont] == null) { //no está lleno
				arregloJugadores[cont] = newPlayer;
				ordenar(cont, puntos, newPlayer);
				try {
					Escribir.guardar(arregloJugadores);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			cont = this.getJugadores().length - 1;
			if(puntos >= arregloJugadores[cont].getPuntuacion()) {	//está lleno
				arregloJugadores[cont] = newPlayer;
				//ORDENAR
				ordenar(cont, puntos, newPlayer);
				//SE PUEDE MOVER LA ESCRITURA AL MÉTODO SALIR() DE LA CLASE JUEGO
				try {
					Escribir.guardar(arregloJugadores);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public String getJugador(int i) {
		String s = "";
		if(arregloJugadores[i-1] != null) {
			return s+i+"- "+arregloJugadores[i-1].getNombre() +" "+arregloJugadores[i-1].getPuntuacion();
		}else {
			return s+i+" - Jugador vacio ----";
		}	
	}
	private void ordenar(int cont, int puntos, Jugador newPlayer) {
		boolean establecido = false;
		while(cont > 0 && !establecido) {
			if(puntos >= arregloJugadores[cont - 1].getPuntuacion()) {
				swap(cont, cont - 1, newPlayer);
				cont--;
			}
			else
				establecido = true;
		}
	}
	private void swap(int i, int j, Jugador newPlayer) {
		Jugador aux = arregloJugadores[j];
		arregloJugadores[j] = newPlayer;
		arregloJugadores[i] = aux;
	}
	private int cantJugadores() {
		int cont = 0; boolean fin = false;
		for(int i = 0; i < arregloJugadores.length && !fin; i++) {
			if(arregloJugadores[i] != null)
				cont++;
			else
				fin = true;
		}
		return cont;
	}
}

