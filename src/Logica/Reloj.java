package Logica;

public class Reloj extends Thread{
	protected int cronometro;
	protected Juego miJuego;
	protected boolean activo;

	public Reloj(Juego juego) {
		miJuego = juego;
		cronometro = 0;
		this.activo=false;
	}
	
	public void run() {
		while(activo) {
			try {
				Thread.sleep(1000);
				cronometro++;
				miJuego.actualizarTiempo(cronometro);
			}
			catch(InterruptedException e) {}
		}
	}
	public void setEstado(boolean activo) {
		this.activo=activo;
	}
	

}
 