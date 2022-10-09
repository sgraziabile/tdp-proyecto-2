package Logica;

public class RelojVelocidad extends Thread {
	protected int tiempoEspera;
	protected SerpienteLogica miSerpiente;
	protected boolean activo;

	public RelojVelocidad(SerpienteLogica serpiente, int t) {
		miSerpiente = serpiente;
		activo = true;
		tiempoEspera = t;
	}
	
	public void run() {
		while(this.activo) {
			try {
				Thread.sleep(tiempoEspera);
				miSerpiente.miJuego.moverSerpiente(miSerpiente.miJuego.getDireccion());;
			}
			catch(InterruptedException e) {}
		}
	}
	
	public void setVelocidad(int v) {
		tiempoEspera = v;
	}
	
	public void detener() {
		activo = false;
	}
}
