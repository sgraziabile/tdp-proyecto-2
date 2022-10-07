package Entidades;

import Logica.SerpienteLogica;

public abstract class Entidad {
	protected float x;
	protected float y;
	protected float alto;
	protected float ancho;
	
	
	public abstract void afectarSerpiente(SerpienteLogica snake);
}
