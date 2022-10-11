package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Banana extends Alimento{
	public Banana(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(3);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		snake.incrementarPuntuacion(50);
		snake.crecer(3);
	}
	public void aceptar(Visitor v) {
		v.visitarBanana(this);
	}
}
