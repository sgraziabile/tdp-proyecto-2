package Logica;

import java.util.ArrayList;

import Entidades.Entidad;
import GUI.EntidadGrafica;

public class Bloque {
	protected int i;
	protected int j;
	protected ArrayList<Entidad> misEntidades;
	protected EntidadGrafica miRepresentacion;
	
	public Bloque(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public ArrayList<Entidad> getEntidades() {
		return misEntidades;
	}
	
	public EntidadGrafica getRepresentacion() {
		return miRepresentacion;
	}
	
	public void ocupar(Entidad e) {
		misEntidades.add(e);
		miRepresentacion.actualizarGrafica();
	}
	
	public void desocupar(Entidad e) {
		misEntidades.remove(e);
		miRepresentacion.borrarGrafica();
	}
}
