package Logica;




public class Tablero {
	protected Bloque[][] grilla;
	
	public Tablero(int tama�o) {
		grilla = new Bloque[tama�o][tama�o];
		for(int i = 0; i < tama�o; i++)
			for(int j = 0; j < tama�o; j++)
				grilla[i][j] = new Bloque(i, j);
	}
	public Bloque getBloque(int i, int j) {
		return grilla[i][j];
	}

	
}
