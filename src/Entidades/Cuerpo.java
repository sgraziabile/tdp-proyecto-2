package Entidades;

import GUI.EntidadGrafica;
import GUI.Ventana;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public class Cuerpo extends Entidad{
	protected Cuerpo siguiente;
	private Ventana v;
	
	public Cuerpo(int x, int y, Ventana v,int color) {
		this.x = x;
		this.y = y;	
		miGrafica = new EntidadGrafica(v, this);
		setGrafica(color);
		this.v=v;
	}
	
	public void aceptar(Visitor v) {
		v.visitarCuerpo(this);
	}
	
	@Override
	public void afectarSerpiente(SerpienteLogica snake,Juego juego) {
		juego.setDireccion(0);
		v.gameOver();
		System.out.println("Choco Cuerpo");
	}

}
