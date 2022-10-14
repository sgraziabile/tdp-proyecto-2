package Logica;
import Datos.Escribir;
import Datos.Leer;
/*
 * La clase Ranking inicializa un arreglo de 5 jugadores y le asigna
 * los jugadores serializados en "ranking.txt".
 * 
 */

public class Ranking {
	
	protected Jugador[] arregloJugadores;
	//Inicializo un arreglo de 5 jugadores.
	public Ranking() {
		arregloJugadores = new Jugador[5];
		setRanking();
	}
	
	public Jugador[] getJugadores() {
		return arregloJugadores;
	}
	//Le asigno el ranking serializado al arreglo de jugadores.
	private void setRanking() {
		try {
			arregloJugadores = Leer.leer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * Agrega un jugador al ranking en base a su puntaje.
	 * Luego lo ordena y guarda los elementos del arreglo en "ranking.txt".
	 * Si el ranking no está lleno, se inserta automáticamente al jugador.
	 * Si está lleno, el jugador se inserta si su puntaje es menor al mínimo del ranking. 
	 */
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
	//Devuelve un string con los datos del jugador del ranking en la posición i. 
	public String getJugador(int i) {
		String s = "";
		if(arregloJugadores[i-1] != null) {
			return s+i+"- "+arregloJugadores[i-1].getNombre() +"   "+arregloJugadores[i-1].getPuntuacion();
		}else {
			return s+i+" - Jugador vacio ----";
		}	
	}
	//Ordena el arreglo de jugadores en base a su puntaje. 
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
	//Intercambia las posiciones de dos elementos del arreglo. 
	private void swap(int i, int j, Jugador newPlayer) {
		Jugador aux = arregloJugadores[j];
		arregloJugadores[j] = newPlayer;
		arregloJugadores[i] = aux;
	}
	//Devuelve la cantidad de jugadores que hay en el ranking. 
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

