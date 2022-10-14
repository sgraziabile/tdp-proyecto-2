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
		miRuta = "Imagenes\\manzana.png";
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(0);
	}
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		juego.incrementarPuntuacion(70);
		snake.crecer(5);
		borrarGrafica();
		juego.decrementarEntidades(this);

	}
	public void aceptar(Visitor v) {
		v.visitarManzana(this);
	}
}