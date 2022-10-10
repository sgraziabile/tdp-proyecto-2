package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Uva extends Alimento{
	public Uva(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		getMiGrafica().setImagen(6);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	
	public void aceptar(Visitor v) {
		v.visitarUva(this);
	}
	
}