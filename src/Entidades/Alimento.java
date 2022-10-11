package Entidades;

import Logica.Juego;
import Logica.SerpienteLogica;

public abstract class Alimento extends Entidad{
	protected int incremento;
	protected int puntuacion;
	
	public abstract void afectarSerpiente(SerpienteLogica snake,Juego juego);
}
