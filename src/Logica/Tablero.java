package Logica;

import Entidades.Entidad;

public class Tablero {
	protected Bloque[][] grilla;
	protected int tamaño;
	
	public Tablero(int tamaño) {
		this.tamaño=tamaño;
		grilla = new Bloque[tamaño][tamaño];
		for(int i = 0; i < tamaño; i++)
			for(int j = 0; j < tamaño; j++)
				grilla[i][j] = new Bloque();
	}
	public Bloque getBloque(int i, int j) {
		return grilla[i][j];
	}
	
	public int getTamanio() {
		return tamaño;
	}
	//Borra las entidades graficas del tablero
	public void borrarTablero() {
		for(int i = 0; i < tamaño; i++)
			for(int j = 0; j < tamaño; j++)
				for(Entidad e:grilla[i][j].getEntidades()) {
					e.borrarGrafica();
				}
	}
	
	
}
