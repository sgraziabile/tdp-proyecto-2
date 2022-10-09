package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Pared extends Entidad{
	public Pared() {
		getMiGrafica().setImagen(8);
	}
	public void afectarSerpiente(SerpienteLogica snake) {	
	}
	public void aceptar(Visitor v) {
		v.visitarPared(this);
	}

}