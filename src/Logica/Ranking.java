package Logica;

public class Ranking {
	
	protected Jugador[] arregloJugadores=new Jugador[5];
	
	public Jugador[] getJugador() {
		return arregloJugadores;
	}
	
	public void agregarJugador(Jugador NEWPLAYER) {
		int cont= 4;
		boolean establecido=false;
		while(cont>=0 && establecido==false) {
			if(arregloJugadores[cont].getPuntuacion()<j.getPuntuacion()) {
				arregloJugadores[cont]=NEWPLAYER;
				establecido=true;
			}
			cont--;
		}
		//TERMINAR METODO DESPUES
	}
	
}
