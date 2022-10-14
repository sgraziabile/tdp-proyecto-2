package GUI;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.Entidad;

public class EntidadGrafica {
	protected JLabel grafica;
	protected final String[] rutasSerpiente  = new String[] {"Imagenes\\Cabeza-normal.png", "Imagenes\\Cabeza-Roja.png", "Imagenes\\Cabeza-Verde.png", "Imagenes\\Cuerpo-Normal.png", "Imagenes\\Cuerpo-Rojo.png", "Imagenes\\Cuerpo-Verde.png" };;	
	protected Ventana ventana;	
	protected Entidad miEntidad;
	
	public EntidadGrafica(Ventana v, Entidad e) {
		grafica = new JLabel();
		ventana = v;
		miEntidad = e;
	}
	
	/*
	  El método setImagen() es para las entidades que no forman parte de la serpiente, es decir, los power ups, los alimentos y las paredes.
	  Todas estas entidades tienen un atributo String que indica la ruta de la imágen.
	 */
	
	public void setImagen() {
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(miEntidad.getMiRuta()).getScaledInstance(20, 20, 0));
		grafica.setIcon(img);
	}
	
	/*
	 El método setImagenSerpiente() recibe como parámetro un entero que nos indicará la ruta que debemos utilizar en rutas serpiente según el color, y si estamos cambiando la cabeza o un cuerpo de la serpiente.
	 */
	public void setImagenSerpiente(int i) {
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(rutasSerpiente[i-1]).getScaledInstance(20, 20, 0));
		grafica.setIcon(img);
	}
	public JLabel getImage() {
		return grafica;
	}
	
	public Entidad getEntidad() {
		return miEntidad;
	}
	
	/*
	 Los métodos actualizarGrafica() y borrarGrafica() le indican a ventana que setee el label correspondiente, o lo borre.
	 */
	
	public void actualizarGrafica() {
		ventana.actualizarGrafica(this);
	}
	
	public void borrarGrafica() {
		ventana.borrarGrafica(this);
	}
}
