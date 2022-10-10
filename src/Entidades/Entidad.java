package Entidades;

import GUI.EntidadGrafica;
import Logica.SerpienteLogica;
import Logica.Visitor;

public abstract class Entidad {
	protected int x;
	protected int y;
	protected final int alto = 20;
	protected final int ancho=20;
	protected EntidadGrafica miGrafica;
	
	public abstract void afectarSerpiente(SerpienteLogica snake);
	
	public EntidadGrafica getMiGrafica() {
		return miGrafica;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getAncho() {
		return ancho;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void aceptar(Visitor v); 
}
