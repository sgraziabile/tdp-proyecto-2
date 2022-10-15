package Logica;

import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JLabel;

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
		miVentana.gameOver();
		cronometro.setEstado(false);
		miSerpiente.borrarGraficaCabeza();
		miTablero.borrarTablero();
		miSerpiente.detenerReloj();
	}
	
	public void jugar() {
		miJugador.setPuntuacion(0);
		direccion = 2;
		cronometro = new Reloj(this);
		cambiarNivel(1);
		cronometro.start();
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
			case 6: miVentana.ganar();
			default:  rutaArchivo="Niveles/Nivel1.txt";
		}
		
		try {
			if(i!=1) {
				miSerpiente.regenerarSerpiente();
				miTablero.borrarTablero();
				JLabel lblnivel = miVentana.setLblNivel(i);
				int nivel = cronometro.cronometro+1;
				int aux = cronometro.cronometro;
				while(aux != nivel) {
					aux = cronometro.cronometro;
					System.out.println(aux);
					System.out.println("n"+nivel);
				}
				miVentana.borrarLblNivel(lblnivel);
			}
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
		getBloque((e.getX()-10)/20,(e.getY()-10)/20).desocupar(e);
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
			 int random = (int) (Math.random()*100)%misEntidades.size();
			 System.out.println(random);
			 Entidad ent = misEntidades.get(random);
			 ent.getMiGrafica().getImage().setVisible(true);
			 miVentana.actualizarGrafica(ent.getMiGrafica());
			 getBloque((ent.getX()-10)/20, (ent.getY()-10)/20).ocupar(ent);
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
	public void actualizarTiempo(int x) {
		miVentana.getCrono().setText(Integer.toString(x));
	}
	
	
	
}
