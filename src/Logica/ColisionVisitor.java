package Logica;
import Entidades.*;


public class ColisionVisitor implements Visitor {
	private SerpienteLogica snake;
	private Juego juego;
	
	public ColisionVisitor(SerpienteLogica snake,Juego juego) {
		this.snake=snake;
		this.juego=juego;
	}
	
	public void visitarPared(Pared p) {
			p.afectarSerpiente(snake,juego);
	}

	
	public void visitarFrutilla(Frutilla f) {
			f.afectarSerpiente(snake,juego);
	}

	
	public void visitarUva(Uva u) {
			u.afectarSerpiente(snake,juego);
	}

	
	public void visitarPera(Pera p) {
			p.afectarSerpiente(snake,juego);
	}

	
	public void visitarManzana(Manzana m) {
			m.afectarSerpiente(snake,juego);
	}

	
	public void visitarBanana(Banana b) {
			b.afectarSerpiente(snake,juego);
	}

	
	public void visitarVerde(Verde v) {
			v.afectarSerpiente(snake,juego);
	}

	
	public void visitarAzul(Azul a) {
			a.afectarSerpiente(snake,juego);
	}

	
	public void visitarRojo(Roja r) {
			r.afectarSerpiente(snake,juego);
	}


	public void visitarCuerpo(Cuerpo c) {
			c.afectarSerpiente(snake,juego);
	}
	
}
