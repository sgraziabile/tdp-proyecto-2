package Logica;

import java.util.ArrayList;
import java.util.List;


import Entidades.Entidad;


public class Bloque {
	protected List<Entidad> misEntidades;
	
	public Bloque() { 
		misEntidades = new ArrayList<Entidad>();
	}
	
	public List<Entidad> getEntidades() {
		return misEntidades;
	}
	
	public void ocupar(Entidad e) {
		e.actualizarGrafica();
	}
	
	public void desocupar(Entidad e) {
		misEntidades.remove(e);
		e.borrarGrafica();	
	}
}
