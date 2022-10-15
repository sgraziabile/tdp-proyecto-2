package Logica;

public class RelojVelocidad extends Thread {
	protected SerpienteLogica miSerpiente;
	protected boolean activo;
	

	public RelojVelocidad(SerpienteLogica serpiente) {
		miSerpiente = serpiente;
		activo = true;
	}
	
	public void run() {
		while(activo) { //borrar activo y cambiar el hilo con start y stop desde afuera
			try {
				Thread.sleep(175);
				miSerpiente.miJuego.miVentana.setPuedeMover(true);
				miSerpiente.miJuego.moverSerpiente();
				
			}
			catch(InterruptedException e) {}
		}
	}
	
	public void setEstado(boolean b) {
		activo = b;
	}
}
