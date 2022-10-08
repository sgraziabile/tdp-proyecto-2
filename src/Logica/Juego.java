package Logica;

import java.util.ArrayList;

import Entidades.Entidad;

public class Juego {
	protected GeneradorNiveles generador;
	protected ArrayList<Entidad> misEntidades;
	protected Reloj cronometro;
	protected Ranking miRanking;
	protected Jugador miJugador;
	protected SerpienteLogica miSerpiente;
	protected Tablero miTablero;
	
	public void jugar() {
		//inicializar el jugador con un metodo por ventana que pida ingresar un string?
		miJugador = new Jugador("");
		
	}
	public void salir() {
		System.exit(0);
	}
	
	public void cambiarNivel() {
		generador.nuevoNivel();
	}
	
	public void moverSerpiente(int direccion) {
		//mover
		controlarColision();
	}
	
	public void decrementarEntidades(Entidad e) {
		misEntidades.remove(e);
		if(!activarEntidad())
			cambiarNivel();
	}
	
	private boolean activarEntidad(){
		if(misEntidades.isEmpty())
			return false;
		else {
			//agregar una entidad random al tablero
			return true;
		}
	}
	
	private void controlarColision() {
		
	}
	public Bloque getBloque(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
