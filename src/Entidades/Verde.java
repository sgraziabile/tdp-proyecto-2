package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Verde extends PowerUp{
	public Verde(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(2);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		snake.incrementarPuntuacion(80);
		snake.crecer(3);
		snake.cambiarGrafica(3);
	}
	public void aceptar(Visitor v) {
		v.visitarVerde(this);
	}
}
