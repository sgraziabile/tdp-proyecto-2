package Logica;

import java.io.IOException;

import java.util.ArrayList;


import Entidades.*;

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
	protected int nivel;
	
	public Juego(Ventana v) {
		miRanking = new Ranking();
		miJugador = new Jugador();
		miVentana = v;
		direccion = 2;
		nivel=1;
	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public void setDireccion(int d) {
		direccion = d;
	}
	
	public void incrementarPuntuacion(int x) {
		miJugador.setPuntuacion(miJugador.getPuntuacion()+x);
	}
	
	public void gameOver() {
		miSerpiente.borrarGrafica();
		miVentana.gameOver();
		miSerpiente.detenerReloj();
		cambiarNivel(1);
	}
	
	public void jugar() {
		direccion = 2;
		cambiarNivel(1);
		miSerpiente = new SerpienteLogica(this);
	}
	
	public void cambiarNivel(int i) {
		String rutaArchivo;
		switch(i){
			case 1: rutaArchivo="Niveles/Nivel1.txt"; break;  
			case 2: rutaArchivo="Niveles/Nivel2.txt";break;
			case 3: rutaArchivo="Niveles/Nivel3.txt";break;
			case 4: rutaArchivo="Niveles/Nivel4.txt";break;
			case 5: rutaArchivo="Niveles/Nivel5.txt";break;
			default:  rutaArchivo="Niveles/Nivel1.txt";
		}
		
		try {
			if(i!=1)
				miSerpiente.regenerarSerpiente();
			misEntidades=GeneradorNiveles.cargarNivel(rutaArchivo,this);	//actualiza la lista de entidades según el nivel correspondiente
		} catch (IOException e) {
			e.printStackTrace();
		}
		activarEntidad();
	}
	
	public synchronized void moverSerpiente() {
		switch(direccion) {	//1 es hacia arriba, 2 hacia la derecha, 3 hacia abajo y 4 hacia la izquierda
		case 1: miSerpiente.mover(0, -20); break;
		case 2: miSerpiente.mover(20, 0);  break;
		case 3: miSerpiente.mover(0, 20); break;
		case 4: miSerpiente.mover(-20, 0); break;
		}
	}
	
	/*
	 Remueve la entidad e de la lista de entidades y desocupa la entidad de la lista de entidades del bloque correspondiente.
	 Si ya no hay mas entidades para activar (el método activarEntidad() devuelve false, cambiar de nivel)
	 */
	
	public void decrementarEntidades(Entidad e) {
		misEntidades.remove(e);
		getBloque(e.getX()/20, primerDigito(e.getY())).desocupar(e);
		if(!activarEntidad()) {
			nivel++;
			cambiarNivel(nivel);
		}
	}
	
	/*
	 Si hay entidades en la lista, activa una random de ellas, haciendo visible su label y ocupando el bloque con ella
	 */
	
	private boolean activarEntidad(){
		if(misEntidades.isEmpty())
			return false;
		else {
			 int random = (int) Math.random()%misEntidades.size();
			 System.out.println(random);
			 Entidad ent = misEntidades.get(random);
			 ent.getMiGrafica().getImage().setVisible(true);
			 miVentana.actualizarGrafica(ent.getMiGrafica());
			 getBloque(ent.getX()/20, ent.getY()/20).ocupar(ent);
			
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
