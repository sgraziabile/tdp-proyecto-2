package Logica;

import java.util.*;

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
		e.getMiGrafica().actualizarGrafica();
	}
	
	public void desocupar(Entidad e) {
		misEntidades.remove(e);
		e.getMiGrafica().borrarGrafica();	
	}
}
