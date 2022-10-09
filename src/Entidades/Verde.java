package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Verde extends PowerUp{
	public Verde() {
		getMiGrafica().setImagen(2);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
			
	}
	public void aceptar(Visitor v) {
		v.visitarVerde(this);
	}
}
