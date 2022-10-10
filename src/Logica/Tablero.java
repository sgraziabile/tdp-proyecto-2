package Logica;




public class Tablero {
	protected Bloque[][] grilla;
	
	public Tablero(int tamaño) {
		grilla = new Bloque[tamaño][tamaño];
		for(int i = 0; i < tamaño; i++)
			for(int j = 0; j < tamaño; j++)
				grilla[i][j] = new Bloque(i, j);
	}
	public Bloque getBloque(int i, int j) {
		return grilla[i][j];
	}

	
}
