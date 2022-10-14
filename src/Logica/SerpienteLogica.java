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
	
	/*
	 El constructor crea una serpiente con una cabeza y dos bloques, de color azul.
	 La entidad cuerpo recibe un int indicando el color de la serpiente, el cual se actualiza en el método setGrafica() de Entidad.
	 */
	
	public SerpienteLogica(Juego j) {
		miJuego = j;
		cuerpo = new ArrayList<Cuerpo>();
		colorSerpiente=1;
		miReloj = new RelojVelocidad(this);
		miReloj.start();
		
		cabeza = new Cuerpo(150, 150, miJuego.getVentana(),colorSerpiente);
		cabeza.setGrafica(colorSerpiente);
		cuerpo.add(cabeza);
		agregarBloque(20, 0);
		agregarBloque(20, 0);
		visitor=new ColisionVisitor(this,miJuego);
	}
	
	public List<Cuerpo> getListaCuerpos(){
		return cuerpo;
	}
	
	/*
	 El método mover recibe los parámetros x, y que se incrementaran a la cabeza de la serpiente.
	 Si el parámetro crecimiento es positivo, entonces no se remueve el último bloque de la lista de cuerpos ni de la lista de entidades del bloque correspondiente.
	 Nota: las entidades las hicimos de 20x20, por lo cual al obtener un bloque usamos el x,y de la entidad dividido 20.
	 */
	
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
		esteBloque.procesarColisiones(visitor, this);
		return pudo;
	}
	
	public void crecer(int p) {
		crecimiento = crecimiento + p;
	}
	
	/*
	 El método crea un nuevo cuerpo del color correspondiente, el cual se añadirá en la lista de cuerpos después de la cabeza y también en la lista de entidades del bloque correspondiente para luego controlar colisiones.
	 Además, se incrementan los parámetros x,y de la serpiente y se actualizan las graficas de la cabeza y el cuerpo añadido.
	 */
	
	private void agregarBloque(int x, int y) {
		Cuerpo nuevo = new Cuerpo(cabeza.getX(), cabeza.getY(), miJuego.getVentana(),colorSerpiente+3);
		cabeza.setX(cabeza.getX()+x);
		cabeza.setY(cabeza.getY()+y);
		cuerpo.add(1, nuevo);
		miJuego.getBloque(nuevo.getX()/20, nuevo.getY()/20).getEntidades().add(nuevo);
		cabeza.actualizarGrafica();
		nuevo.actualizarGrafica();
	}
	
	public Cuerpo getCabeza() {
		return cabeza;
	}
	
	/*
	 Se actualiza la gráfica de toda la serpiente, en el caso de que haya chocado con un power up
	 */
	
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
	
	/*
	 Se regenera la serpiente con únicamente la cabeza y dos bloques del color correspondiente para cuando cambia de nivel.
	 */
	
	public void regenerarSerpiente() {
		for(Cuerpo aux:cuerpo) {
			aux.borrarGrafica();
		}
		cuerpo = new ArrayList<Cuerpo>();
		crecimiento=0;
		miJuego.setDireccion(2);
		cabeza = new Cuerpo(150, 150, miJuego.getVentana(),colorSerpiente);
		cabeza.setGrafica(colorSerpiente);
		cuerpo.add(cabeza);
		agregarBloque(20, 0);
		agregarBloque(20, 0);
		
	}
	
	/*
	 Cuando el jugador perdió, borraremos toda la grafica de la serpiente con el método borrar gráfica.
	 */
	
	public void borrarGraficaCabeza() {
		cabeza.borrarGrafica();
	}
	
	public void detenerReloj() {
		miReloj.setEstado(false);
		miReloj.stop();
	}
	
}
