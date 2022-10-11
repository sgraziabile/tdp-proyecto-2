package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Pared extends Entidad{
	private Ventana v;
	public Pared(int x, int y, Ventana v) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		this.v=v;
		getMiGrafica().setImagen(8);
	}
	
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {	
		juego.setDireccion(0);
		v.gameOver();
		System.out.println("Choco Pared");
	}
	
	public void aceptar(Visitor v) {
		v.visitarPared(this);
	}

}