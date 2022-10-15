package Logica;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import Entidades.Entidad;


public class Bloque {
	protected ArrayList<Entidad> misEntidades;
	
	public Bloque() { 
		misEntidades = new ArrayList<Entidad>();
	}
	
	public List<Entidad> getEntidades() {
		return misEntidades;
	}
	
	public void ocupar(Entidad e) {
		misEntidades.add(e);
		e.actualizarGrafica();
	}
	
	public void desocupar(Entidad e) {
		misEntidades.remove(e);
		e.borrarGrafica();	
	}
	//Procesa las coliciones de las entidades del bloque con la cabeza de la serpiente
	public void procesarColisiones(Visitor v,SerpienteLogica snake) {
		ArrayList<Entidad> colisiones=(ArrayList<Entidad>) misEntidades.clone();
		for(Entidad e:colisiones) {
			if(verColisiones(e,snake.getCabeza()) && e.getMiGrafica().getImage().isVisible())
				e.aceptar(v);
			}
		}
	
	
	/**
	 * Arma la hitbox de una entidad e pasada por parametro
	 * @param e entidad a armar hitbox
	 * @return rectangulo que representa la hitbox
	 */
	private Rectangle armarHitboxEntidad(Entidad e) {
		Dimension dimensionEntidad=new Dimension(e.getMiGrafica().getImage().getIcon().getIconWidth(),e.getMiGrafica().getImage().getIcon().getIconHeight());
		Point ubicacionEntidad=new Point(e.getMiGrafica().getImage().getX(),e.getMiGrafica().getImage().getY());
		Rectangle hitboxEntidad=new Rectangle(ubicacionEntidad,dimensionEntidad);
		return hitboxEntidad;
	}

	/**
	 * Calcula si hay colision entre dos entidades a y b.
	 * @param a Entidad a
	 * @param b Entidad b
	 * @return true si hubo colision, false caso contrario.
	 */
	private boolean verColisiones(Entidad a,Entidad b) {
		
		Rectangle hitboxEntidadA=armarHitboxEntidad(a);
		Rectangle hitboxEntidadB=armarHitboxEntidad(b);
		boolean colisiono=false;		
		if(hitboxEntidadA.intersects(hitboxEntidadB))
			colisiono=true;
		return colisiono;
	}
	
	
	
}
