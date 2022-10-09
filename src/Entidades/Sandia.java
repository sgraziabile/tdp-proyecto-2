package Entidades;


import Logica.SerpienteLogica;
import Logica.Visitor;

public class Sandia extends Alimento{
	public Sandia() {
		getMiGrafica().setImagen(5);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	public void aceptar(Visitor v) {
		v.visitarSandia(this);
	}
	
	
}