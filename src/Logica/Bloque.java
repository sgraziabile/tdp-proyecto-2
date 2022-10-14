package Logica;

import java.util.ArrayList;
import java.util.List;


import Entidades.Entidad;


public class Bloque {
	protected List<Entidad> misEntidades;
	
	public Bloque(int i, int j) {
		misEntidades = new ArrayList<Entidad>();
	}
	
	public List<Entidad> getEntidades() {
		return misEntidades;
	}
	
	public void ocupar(Entidad e) {
		misEntidades.add(e);
		e.actualizarGrafica();
	}
	
	public void desocupar(Entidad e) {
		misEntidades.remove(e);
		e.borrarGrafica();	
	}
}
