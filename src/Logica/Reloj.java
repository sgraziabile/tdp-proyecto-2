package Logica;

public class Reloj {
	protected int cronometro;
	protected Juego miJuego;
	protected boolean activo;

	public Reloj(Juego juego) {
		miJuego = juego;
		cronometro = 0;
	}
	
	public void run() {
		while(this.activo) {
			try {
				Thread.sleep(1000);
				cronometro++;
			}
			catch(InterruptedException e) {}
		}
	}
	
	public int getCronometro() {
		return cronometro;
	}
	
	public void detener() {
		activo = false;
	}
}
 