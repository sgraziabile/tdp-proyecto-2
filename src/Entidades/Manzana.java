package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Manzana extends Alimento{
	public Manzana(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(4);
	}
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		snake.incrementarPuntuacion(70);
		snake.crecer(5);
		miGrafica.borrarGrafica();
		juego.decrementarEntidades(this);

	}
	public void aceptar(Visitor v) {
		v.visitarManzana(this);
	}
}