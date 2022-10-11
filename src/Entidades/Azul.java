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
		setGrafica(0);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
			snake.incrementarPuntuacion(70);
			snake.crecer(3);
			snake.cambiarGrafica(0);
	}
	public void aceptar(Visitor v) {
		v.visitarAzul(this);
	}
}
