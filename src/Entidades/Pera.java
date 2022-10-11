package Entidades;


import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Pera extends Alimento{
	public Pera(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(5);
	}
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		snake.incrementarPuntuacion(60);
		snake.crecer(2);
		miGrafica.borrarGrafica();
		juego.decrementarEntidades(this);

	}
	public void aceptar(Visitor v) {
		v.visitarPera(this);
	}
	
	
}