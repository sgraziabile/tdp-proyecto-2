package Entidades;


import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Pera extends Alimento{
	public Pera(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		getMiGrafica().setImagen(5);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	public void aceptar(Visitor v) {
		v.visitarPera(this);
	}
	
	
}