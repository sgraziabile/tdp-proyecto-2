package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Manzana extends Alimento{
	public Manzana() {
		getMiGrafica().setImagen(4);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	public void aceptar(Visitor v) {
		v.visitarManzana(this);
	}
}