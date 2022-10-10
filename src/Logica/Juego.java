package Logica;

import java.io.IOException;
import java.util.ArrayList;

import Entidades.Azul;
import Entidades.Banana;
import Entidades.Entidad;
import Entidades.Frutilla;
import Entidades.Manzana;
import Entidades.Pared;
import Entidades.Roja;
import Entidades.Sandia;
import Entidades.Uva;
import Entidades.Verde;
import GUI.Ventana;

public class Juego {
	protected ArrayList<Entidad> misEntidades;
	protected Reloj cronometro;
	protected Ranking miRanking;
	protected Jugador miJugador;
	protected SerpienteLogica miSerpiente;
	protected Tablero miTablero;
	protected Ventana miVentana;
	protected int direccion;
	
	public Juego(Ventana v) {
		miRanking = new Ranking();
		miJugador = new Jugador();
		miVentana = v;

	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public SerpienteLogica getSerpiente() {
		return miSerpiente;
	}
	
	
	public void jugar() {
		cambiarNivel(1);
		miSerpiente = new SerpienteLogica(this);

	}
	
	public void cambiarNivel(int i) {
		String rutaArchivo;
		switch(i){
			case 1: rutaArchivo="Niveles/Nivel1.txt";break; 
			//Completar despues con los niveles.
			default:  rutaArchivo="Niveles/Nivel1.txt";
		}
		
		try {
			misEntidades=GeneradorNiveles.cargarNivel(rutaArchivo,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		activarEntidad();
	}
	
	public void moverSerpiente(int direccion) {
		//mover
		;
	}
	
	public void decrementarEntidades(Entidad e) {
		misEntidades.remove(e);
		getBloque(primerDigito(e.getX()), primerDigito(e.getY())).desocupar(e);;
		if(!activarEntidad())
			cambiarNivel(1);
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
	
	public void setTablero(Tablero t) {
		miTablero=t;
	}
	
	private int primerDigito(int num) {
		Integer numero = Integer.parseInt(""+num);
		int desplazamiento = Double.valueOf(Math.pow(10, numero.SIZE-1)).intValue();
		return num/desplazamiento;
	}

}
