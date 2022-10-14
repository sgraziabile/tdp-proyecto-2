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
		colorSerpiente=1;
		miReloj = new RelojVelocidad(this, 300);
		miReloj.start();
		
		cabeza = new Cuerpo(150, 150, miJuego.getVentana(),colorSerpiente);
		cabeza.getMiGrafica().setImagenSerpiente(colorSerpiente);
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
			miJuego.getBloque(cuerpo.get(cuerpo.size()-1).getX()/20,cuerpo.get(cuerpo.size()-1).getY()/20).getEntidades().remove(cuerpo.get(cuerpo.size()-1));
			cuerpo.get(cuerpo.size()-1).borrarGrafica();
			cuerpo.remove(cuerpo.get(cuerpo.size()-1));
		}

		esteBloque = miJuego.miTablero.getBloque((cabeza.getX()/20),(cabeza.getY()/20));
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
		miJuego.getBloque(nuevo.getX()/20, nuevo.getY()/20).getEntidades().add(nuevo);
		cabeza.actualizarGrafica();
		nuevo.actualizarGrafica();
	}
	
	public void cambiarVelocidad(int v) {
		miReloj.setVelocidad(v);
	}
	
	
	public Cuerpo getCabeza() {
		return cabeza;
	}
	
	public void cambiarGrafica(int i) { 
			cabeza.setGrafica(i+1);
			Iterator<Cuerpo> it=cuerpo.iterator();
			Cuerpo aux=it.next();
			while(it.hasNext()) {
				aux=it.next();
				aux.setGrafica(i+4);
			}
			colorSerpiente = i+1;
	}
	
	public void regenerarSerpiente() {
		for(Cuerpo aux:cuerpo) {
			aux.borrarGrafica();
		}
		cuerpo = new ArrayList<Cuerpo>();
		colorSerpiente=1;
		miJuego.setDireccion(2);
		miReloj.setVelocidad(300);
		cabeza = new Cuerpo(150, 150, miJuego.getVentana(),colorSerpiente);
		cabeza.setGrafica(colorSerpiente);
		cuerpo.add(cabeza);
		agregarBloque(20, 0);
		agregarBloque(20, 0);
		
	}
	
	public void borrarGrafica() {
		for(Cuerpo aux:cuerpo) {
			aux.borrarGrafica();
		}
		cuerpo = new ArrayList<Cuerpo>();
	}
	
	public void detenerReloj() {
		miReloj.stop();
	}
	
}
