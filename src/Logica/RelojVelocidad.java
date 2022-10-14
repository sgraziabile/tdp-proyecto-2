package Logica;

public class RelojVelocidad extends Thread {
	protected int tiempoEspera;
	protected SerpienteLogica miSerpiente;
	

	public RelojVelocidad(SerpienteLogica serpiente, int t) {
		miSerpiente = serpiente;
		tiempoEspera = t;
	}
	
	public void run() {
		while(true) { //borrar activo y cambiar el hilo con start y stop desde afuera
			try {
				Thread.sleep(tiempoEspera);
				miSerpiente.miJuego.moverSerpiente();
			}
			catch(InterruptedException e) {}
		}
	}
	
	public void setVelocidad(int v) {
		tiempoEspera = v;
	}
	
}
