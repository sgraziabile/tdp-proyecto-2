package Entidades;


import Logica.SerpienteLogica;
import Logica.Visitor;

public class Frutilla extends Alimento{
	public Frutilla() {
		getMiGrafica().setImagen(7);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	public void aceptar(Visitor v) {
		v.visitarFrutilla(this);
	}
}