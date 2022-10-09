package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Azul extends PowerUp{
	public Azul() {
		getMiGrafica().setImagen(0);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
			
	}
	public void aceptar(Visitor v) {
		v.visitarAzul(this);
	}
}
