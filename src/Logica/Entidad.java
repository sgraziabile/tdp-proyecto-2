package Logica;

public abstract class Entidad {
	protected String imagen;
	public String getImagen() {
		return imagen;
	}
	public abstract afectarSerpiente(SerpienteLogica snake, Jugador jugador);
}
