package Entidades;

import Logica.SerpienteLogica;

public abstract class PowerUp extends Entidad {
	protected static final int incremento = 3;
	protected int puntuacion;
	
	public abstract void afectarSerpiente(SerpienteLogica snake);
	
}
