package Entidades;


import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Roja extends PowerUp{
	public Roja(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		getMiGrafica().setImagen(1);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
			
	}
	public void aceptar(Visitor v) {
		v.visitarRojo(this);
	}
	
}
