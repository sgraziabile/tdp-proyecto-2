package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Pared extends Entidad{
	public Pared(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		getMiGrafica().setImagen(8);
	}
	
	public void afectarSerpiente(SerpienteLogica snake) {	
	}
	
	public void aceptar(Visitor v) {
		v.visitarPared(this);
	}

}