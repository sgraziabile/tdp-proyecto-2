package Logica;

import Entidades.*;

public interface Visitor {
	
	public void visitarPared(Pared p);
	
	public void visitarFrutilla(Frutilla f);
	
	public void visitarUva(Uva u);
	
	public void visitarPera(Pera p);
	
	public void visitarManzana(Manzana m);
	
	public void visitarBanana(Banana b);
	
	public void visitarVerde(Verde v);
	
	public void visitarAzul(Azul a);
	
	public void visitarRojo(Roja r);
	
	public void visitarCuerpo(Cuerpo p);
	
	
}
