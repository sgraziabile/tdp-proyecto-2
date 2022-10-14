package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Pared extends Entidad{

	public Pared(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miRuta = "Imagenes\\pared.png";
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(0);
	}
	
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {	
		juego.gameOver();
		System.out.println("Choco Pared");
	}
	
	public void aceptar(Visitor v) {
		v.visitarPared(this);
	}

}