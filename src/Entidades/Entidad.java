package Entidades;

import GUI.EntidadGrafica;
import Logica.Juego;
import Logica.SerpienteLogica;
import Logica.Visitor;

public abstract class Entidad {
	protected int x;
	protected int y;
	protected final int alto =20;
	protected final int ancho=20;
	protected EntidadGrafica miGrafica;
	protected String miRuta;
	
	public abstract void afectarSerpiente(SerpienteLogica snake,Juego juego);
	
	public EntidadGrafica getMiGrafica() {
		return miGrafica;
	}
	
	public void setGrafica(int i) {
		if(i == 0) {
			miGrafica.setImagen();
			actualizarGrafica();
		}else {
			miGrafica.setImagenSerpiente(i);
			actualizarGrafica();
		}
		
	}
	
	public void borrarGrafica() {
		miGrafica.borrarGrafica();
	}
	
	public void actualizarGrafica() {
		miGrafica.actualizarGrafica();
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getAncho() {
		return ancho;
	}
	public String getMiRuta() {
		return miRuta;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void aceptar(Visitor v); 
}
