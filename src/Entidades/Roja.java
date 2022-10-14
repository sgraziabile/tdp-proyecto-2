package Entidades;


import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Roja extends PowerUp{
	public Roja(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;
		miRuta ="Imagenes\\roja.png";
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(0);
	}
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		juego.incrementarPuntuacion(50);
		snake.crecer(3);
		snake.cambiarGrafica(1);
		borrarGrafica();
		juego.decrementarEntidades(this);

	}
	public void aceptar(Visitor v) {
		v.visitarRojo(this);
	}
	
}
