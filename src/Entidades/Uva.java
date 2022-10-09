package Entidades;

import Logica.SerpienteLogica;
import Logica.Visitor;

public class Uva extends Alimento{
	public Uva() {
		getMiGrafica().setImagen(6);
	}
	public void afectarSerpiente(SerpienteLogica snake) {
		
	}
	
	public void aceptar(Visitor v) {
		v.visitarUva(this);
	}
	
}