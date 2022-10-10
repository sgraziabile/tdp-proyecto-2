package Logica;

import java.util.*;

import Entidades.*;

public class SerpienteLogica  {
	protected int crecimiento;
	protected List<Cuerpo> cuerpo;
	protected Cuerpo cabeza;
	protected Juego miJuego;
	protected RelojVelocidad miReloj;
	
	public SerpienteLogica() {
		cuerpo = new ArrayList<Cuerpo>();
		cabeza = new Cuerpo(10, 10);
		cabeza.getMiGrafica().setImagen(9);
		cabeza.setX(10);
		cabeza.setY(10);
		cuerpo.add(cabeza);
		agregarBloque(cabeza.getX()+5, cabeza.getY()+5);
		agregarBloque(cabeza.getX()+5, cabeza.getY()+5);
	}
	
	public List<Cuerpo> getListaCuerpos(){
		return cuerpo;
	}
	
	public boolean mover(int x, int y) {
		boolean pudo = false;
		Bloque esteBloque;
		if (crecimiento>0) {
			agregarBloque(x,y);
			crecimiento--;
		}
		else {
			agregarBloque(x,y);
			miJuego.getBloque(cuerpo.get(cuerpo.size()-1).getX(), cuerpo.get(cuerpo.size()-1).getY());
			cuerpo.remove(cuerpo.size()-1);
		}
		esteBloque = miJuego.miTablero.getBloque((int)cabeza.getX(), (int)cabeza.getY());
		for (Entidad e: esteBloque.getEntidades())
			if (colisiono(e)) {
				//solucionar colision con visitor
				break;
			}
		return pudo;
	}
	
	public void crecer(int p) {
		crecimiento = crecimiento + p;
	}
	
	private boolean colisiono(Entidad e) {
		return cabeza.getX()>=e.getX() && cabeza.getX()<=e.getX()+e.getAncho() && cabeza.getY()>=e.getY() && cabeza.getY()<=e.getY()+e.getAncho();
	}
	
	private void agregarBloque(int x, int y) {
		Cuerpo nuevo = new Cuerpo(cabeza.getX(), cabeza.getY(), miJuego.getVentana());
		cabeza.setX(cabeza.getX()+x);
		cabeza.setY(cabeza.getY()+y);
		cuerpo.add(1, nuevo);
		nuevo.getMiGrafica().actualizarGrafica();
	}
	
	public void cambiarVelocidad(int v) {
		miReloj.setVelocidad(v);
	}
	
	
	public Cuerpo getCabeza() {
		return cabeza;
	}
	
	//preguntar si va cambiar puntaje o no
}
