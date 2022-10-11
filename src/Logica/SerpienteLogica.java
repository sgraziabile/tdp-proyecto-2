package Logica;

import java.util.*;

import Entidades.*;

public class SerpienteLogica  {
	protected int crecimiento;
	protected List<Cuerpo> cuerpo;
	protected Cuerpo cabeza;
	protected Juego miJuego;
	protected RelojVelocidad miReloj;
	private ColisionVisitor visitor;
	
	public SerpienteLogica(Juego j) {
		miJuego = j;
		cuerpo = new ArrayList<Cuerpo>();
		
		miReloj = new RelojVelocidad(this, 300);
		miReloj.start();
		
		cabeza = new Cuerpo(150, 150, miJuego.getVentana());
		cabeza.getMiGrafica().setImagen(9);
		cuerpo.add(cabeza);
		agregarBloque(20, 0);
		agregarBloque(20, 0);
		
		visitor=new ColisionVisitor(this);
	}
	
	public List<Cuerpo> getListaCuerpos(){
		return cuerpo;
	}
	
	public synchronized boolean mover(int x, int y) {
		boolean pudo = false;
		Bloque esteBloque;
		if (crecimiento>0) {
			agregarBloque(x,y);
			crecimiento--;
		}
		else {
			agregarBloque(x,y);
			cuerpo.get(cuerpo.size()-1).getMiGrafica().borrarGrafica();
			cuerpo.remove(cuerpo.get(cuerpo.size()-1));
		}
		//esteBloque = miJuego.miTablero.getBloque((int)cabeza.getX(), (int)cabeza.getY());
		//visitor.procesarColisiones(esteBloque.getEntidades());
				
		return pudo;
	}
	
	public void crecer(int p) {
		crecimiento = crecimiento + p;
	}
	
	private void agregarBloque(int x, int y) {
		Cuerpo nuevo = new Cuerpo(cabeza.getX(), cabeza.getY(), miJuego.getVentana());
		cabeza.setX(cabeza.getX()+x);
		cabeza.setY(cabeza.getY()+y);
		cuerpo.add(1, nuevo);
		cabeza.getMiGrafica().actualizarGrafica();
		nuevo.getMiGrafica().actualizarGrafica();
	}
	
	public void cambiarVelocidad(int v) {
		miReloj.setVelocidad(v);
	}
	
	
	public Cuerpo getCabeza() {
		return cabeza;
	}
	
	public void incrementarPuntuacion(int x) {
		miJuego.getJugador().setPuntuacion(miJuego.getJugador().getPuntuacion()+x);
	}
	
	public void cambiarGrafica(int i) { //poner bien esto
			cabeza.setGrafica(9);
			for (Cuerpo c: cuerpo) {
				c.setGrafica(i+9);
			}
	}
}
