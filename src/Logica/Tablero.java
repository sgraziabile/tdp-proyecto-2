package Logica;

import Entidades.Entidad;

public class Tablero {
	protected Bloque[][] grilla;
	protected int tama�o;
	
	public Tablero(int tama�o) {
		this.tama�o=tama�o;
		grilla = new Bloque[tama�o][tama�o];
		for(int i = 0; i < tama�o; i++)
			for(int j = 0; j < tama�o; j++)
				grilla[i][j] = new Bloque();
	}
	public Bloque getBloque(int i, int j) {
		return grilla[i][j];
	}
	
	public int getTamanio() {
		return tama�o;
	}
	//Borra las entidades graficas del tablero
	public void borrarTablero() {
		for(int i = 0; i < tama�o; i++)
			for(int j = 0; j < tama�o; j++)
				for(Entidad e:grilla[i][j].getEntidades()) {
					e.borrarGrafica();
				}
	}
	
	
}
