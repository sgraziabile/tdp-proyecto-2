package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Cuerpo extends Entidad{
	protected Cuerpo siguiente;
	
	public Cuerpo(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		getMiGrafica().setImagen(10);
	}
	
	public void aceptar(Visitor v) {
		v.visitarCuerpo(this);
	}
	
	@Override
	public void afectarSerpiente(SerpienteLogica snake) {
		// TODO Auto-generated method stub
		
	}

}
