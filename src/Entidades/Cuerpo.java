package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Cuerpo extends Entidad{
	protected Cuerpo siguiente;
	
	public Cuerpo(int x, int y) {
		this.x = x;
		this.y = y;
		getMiGrafica().setImagen(10);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void aceptar(Visitor v) {
		v.visitarCuerpo(this);
	}
	
	@Override
	public void afectarSerpiente(SerpienteLogica snake) {
		// TODO Auto-generated method stub
		
	}

}