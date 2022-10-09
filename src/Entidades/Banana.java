package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Banana extends Alimento{
	public Banana() {
		getMiGrafica().setImagen(3);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	public void aceptar(Visitor v) {
		v.visitarBanana(this);
	}
}
