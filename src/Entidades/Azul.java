package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Azul extends PowerUp{
	public Azul(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		getMiGrafica().setImagen(0);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
			snake.incrementarPuntuacion(50);
			snake.crecer(3);
	}
	public void aceptar(Visitor v) {
		v.visitarAzul(this);
	}
}
