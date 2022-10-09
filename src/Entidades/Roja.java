package Entidades;


import Logica.SerpienteLogica;
import Logica.Visitor;

public class Roja extends PowerUp{
	public Roja() {
		getMiGrafica().setImagen(1);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
			
	}
	public void aceptar(Visitor v) {
		v.visitarRojo(this);
	}
	
}
