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
	private int colorSerpiente;
	
	public SerpienteLogica(Juego j) {
		miJuego = j;
		cuerpo = new ArrayList<Cuerpo>();
		colorSerpiente=9;
		miReloj = new RelojVelocidad(this, 300);
		miReloj.start();
		
		cabeza = new Cuerpo(150, 150, miJuego.getVentana(),colorSerpiente);
		cabeza.getMiGrafica().setImagen(9);
		cuerpo.add(cabeza);
		agregarBloque(20, 0);
		agregarBloque(20, 0);
		
		visitor=new ColisionVisitor(this,miJuego);
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

		esteBloque = miJuego.miTablero.getBloque(cabeza.getX()/20,cabeza.getY()/20);
		visitor.procesarColisiones(esteBloque.getEntidades());
		return pudo;
	}
	
	public void crecer(int p) {
		crecimiento = crecimiento + p;
	}
	
	private void agregarBloque(int x, int y) {
		Cuerpo nuevo = new Cuerpo(cabeza.getX(), cabeza.getY(), miJuego.getVentana(),colorSerpiente+3);
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
	
	public void cambiarGrafica(int i) { 
			cabeza.getMiGrafica().setImagen(i+9);
			cabeza.getMiGrafica().actualizarGrafica();
			Iterator<Cuerpo> it=cuerpo.iterator();
			Cuerpo aux=it.next();
			while(it.hasNext()) {
				aux=it.next();
				aux.getMiGrafica().setImagen(i+12);
				aux.getMiGrafica().actualizarGrafica();
			}
			setColor(i+9);
	}
	public void setColor(int i) {
		colorSerpiente=i;
	}
	
}
