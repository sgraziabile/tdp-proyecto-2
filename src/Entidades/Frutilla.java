package Entidades;


import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Frutilla extends Alimento{
	public Frutilla(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(7);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		snake.incrementarPuntuacion(25);
		snake.crecer(4);
	}
	public void aceptar(Visitor v) {
		v.visitarFrutilla(this);
	}
}