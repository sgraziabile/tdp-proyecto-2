package Logica;

import java.util.ArrayList;

import Entidades.Entidad;
import GUI.Ventana;

public class Juego {
	protected static GeneradorNiveles generador;
	protected ArrayList<Entidad> misEntidades;
	protected Reloj cronometro;
	protected Ranking miRanking;
	protected Jugador miJugador;
	protected SerpienteLogica miSerpiente;
	protected Tablero miTablero;
	protected Ventana miVentana;
	protected int direccion;
	
	public Juego() {
		miRanking = new Ranking();
		miJugador = new Jugador();
	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public SerpienteLogica getSerpiente() {
		return miSerpiente;
	}
	
	public void jugar() {
		miSerpiente = new SerpienteLogica();
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
		getBloque(primerDigito(e.getX()), primerDigito(e.getY())).desocupar(e);;
		if(!activarEntidad())
			cambiarNivel();
	}
	
	private boolean activarEntidad(){
		if(misEntidades.isEmpty())
			return false;
		else {
			 int random = (int) Math.floor(Math.random()*(0-misEntidades.size()+1)+misEntidades.size());
			 Entidad ent = misEntidades.get(random);
			 miVentana.actualizarGrafica(ent.getMiGrafica());
			 getBloque(primerDigito(ent.getX()), primerDigito(ent.getY())).ocupar(ent);
			return true;
		}
	}
	
	private void controlarColision() {
		
	}
	public Bloque getBloque(int i, int j) {
		return miTablero.getBloque(i, j);
	}
	public Ranking getMiRanking() {
		return miRanking;
	}
	public Jugador getJugador() {
		return miJugador;
	}
	
	public Ventana getVentana() {
		return miVentana;
	}
	
	private int primerDigito(int num) {
		Integer numero = Integer.parseInt(""+num);
		int desplazamiento = Double.valueOf(Math.pow(10, numero.SIZE-1)).intValue();
		return num/desplazamiento;
	}

}
