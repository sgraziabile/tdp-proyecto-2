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
	
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	@Override
	public void afectarSerpiente(SerpienteLogica snake) {
		// TODO Auto-generated method stub
		
	}

}
