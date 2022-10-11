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
		setGrafica(1);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		snake.incrementarPuntuacion(50);
		snake.crecer(3);
		snake.cambiarGrafica(1);
	}
	public void aceptar(Visitor v) {
		v.visitarRojo(this);
	}
	
}
