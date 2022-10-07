package Entidades;

import Logica.SerpienteLogica;

public class Cuerpo extends Entidad{
	protected Cuerpo siguiente;
	
	public Cuerpo(float x, float y, float alto, float ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho= ancho;
	}
	@Override
	public void afectarSerpiente(SerpienteLogica snake) {
		// TODO Auto-generated method stub
		
	}

}
