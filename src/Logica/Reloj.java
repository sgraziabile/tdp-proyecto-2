package Logica;

public class Reloj extends Thread {
	protected int cronometro;
	protected Juego miJuego;

	public Reloj(Juego juego) {
		miJuego = juego;
		cronometro = 0;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				cronometro++;
				miJuego.actualizarTiempo(cronometro);
			}
			catch(InterruptedException e) {}
		}
	}
	
	
}
 