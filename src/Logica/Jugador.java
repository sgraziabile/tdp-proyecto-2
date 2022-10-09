package Logica;

import java.io.Serializable;

public class Jugador implements Serializable {
	protected int puntuacion;
	protected String nombre;
	
	public Jugador(String n) {
		nombre = n;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion=puntuacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
