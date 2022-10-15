package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Uva extends Alimento{
	public Uva(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miRuta = "Imagenes\\uvas.png";
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(0);
	}
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		juego.incrementarPuntuacion(66);
		snake.crecer(4);
		borrarGrafica();
		juego.decrementarEntidades(this);
	}
	
	public void aceptar(Visitor v) {
		v.visitarUva(this);
	}
	
}