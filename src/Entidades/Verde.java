package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Verde extends PowerUp{
	public Verde(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miRuta = "Imagenes\\verde.png";
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(0);
	}
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		snake.incrementarPuntuacion(80);
		snake.crecer(3);
		snake.cambiarGrafica(3);
		miGrafica.borrarGrafica();
		juego.decrementarEntidades(this);

	}
	public void aceptar(Visitor v) {
		v.visitarVerde(this);
	}
}
