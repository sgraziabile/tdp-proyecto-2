package Logica;

public class RelojVelocidad extends Thread {
	protected SerpienteLogica miSerpiente;
	

	public RelojVelocidad(SerpienteLogica serpiente, int t) {
		miSerpiente = serpiente;
	}
	
	public void run() {
		while(true) { //borrar activo y cambiar el hilo con start y stop desde afuera
			try {
				Thread.sleep(175);
				miSerpiente.miJuego.moverSerpiente();
			}
			catch(InterruptedException e) {}
		}
	}
	
	
	
}
