package Entidades;

import Logica.SerpienteLogica;

public abstract class Entidad {
	protected int x;
	protected int y;
	protected int alto;
	protected int ancho;
	
	
	public abstract void afectarSerpiente(SerpienteLogica snake);
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
}
