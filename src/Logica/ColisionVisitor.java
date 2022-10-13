package Logica;
import Entidades.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.List;


public class ColisionVisitor implements Visitor {
	private SerpienteLogica snake;
	private Juego juego;
	
	public ColisionVisitor(SerpienteLogica snake,Juego juego) {
		this.snake=snake;
		this.juego=juego;
	}
	
	public void visitarPared(Pared p) {
		boolean colisiono=verColisiones(snake.getCabeza(),p);
		if(colisiono)
			p.afectarSerpiente(snake,juego);
	}

	
	public void visitarFrutilla(Frutilla f) {
		boolean colisiono=verColisiones(snake.getCabeza(),f);
		if(colisiono)
			f.afectarSerpiente(snake,juego);
	}

	
	public void visitarUva(Uva u) {
		boolean colisiono=verColisiones(snake.getCabeza(),u);
		if(colisiono)
			u.afectarSerpiente(snake,juego);
		
	}

	
	public void visitarPera(Pera p) {
		boolean colisiono=verColisiones(snake.getCabeza(),p);
		if(colisiono)
			p.afectarSerpiente(snake,juego);
		
	}

	
	public void visitarManzana(Manzana m) {
		boolean colisiono=verColisiones(snake.getCabeza(),m);
		if(colisiono)
			m.afectarSerpiente(snake,juego);
		
	}

	
	public void visitarBanana(Banana b) {
		boolean colisiono=verColisiones(snake.getCabeza(),b);
		if(colisiono)
			b.afectarSerpiente(snake,juego);
		
	}

	
	public void visitarVerde(Verde v) {
		boolean colisiono=verColisiones(snake.getCabeza(),v);
		if(colisiono)
			v.afectarSerpiente(snake,juego);
		
	}

	
	public void visitarAzul(Azul a) {
		boolean colisiono=verColisiones(snake.getCabeza(),a);
		if(colisiono)
			a.afectarSerpiente(snake,juego);
		
	}

	
	public void visitarRojo(Roja r) {
		boolean colisiono=verColisiones(snake.getCabeza(),r);
		if(colisiono)
			r.afectarSerpiente(snake,juego);
		
	}


	public void visitarCuerpo(Cuerpo c) {
		boolean colisiono=verColisiones(snake.getCabeza(),c);
		System.out.println("Chequeo colision");
		if(colisiono)
			c.afectarSerpiente(snake,juego);
		
	}

	
	public void procesarColisiones(List<Entidad> entidades) {
		Iterator<Entidad> it=entidades.iterator();
		Entidad aux=null;
		while(it.hasNext()) {
			aux=it.next();
			if(aux.getMiGrafica().getImage().isVisible())
				aux.aceptar(this);
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
