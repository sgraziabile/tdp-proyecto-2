package GUI;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.Entidad;

public class EntidadGrafica {
	protected JLabel grafica;
	protected final String[] rutas  = new String[] {"Imagenes\\azul.png","Imagenes\\roja.png","Imagenes\\verde.png","Imagenes\\platanos.png","Imagenes\\manzana.png", "Imagenes\\pera.png","Imagenes\\uvas.png", "Imagenes\\fresa.png", "Imagenes\\pared.png", "Imagenes\\Cabeza-normal.png", "Imagenes\\Cabeza-Roja.png", "Imagenes\\Cabeza-Verde.png", "Imagenes\\Cuerpo-Normal.png", "Imagenes\\Cuerpo-Rojo.png", "Imagenes\\Cuerpo-Verde.png" };;	
	protected Ventana ventana;	
	protected Entidad miEntidad;
	
	public EntidadGrafica(Ventana v, Entidad e) {
		grafica = new JLabel();
		ventana = v;
		miEntidad = e;
	}
	
	public void setImagen(int i) {
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.rutas[i]).getScaledInstance(20, 20, 0));
		grafica.setIcon(img);
	}
	
	public JLabel getImage() {
		return grafica;
	}
	
	public Entidad getEntidad() {
		return miEntidad;
	}
	
	public void actualizarGrafica() {
		ventana.actualizarGrafica(this);
	}
	
	public void borrarGrafica() {
		ventana.borrarGrafica(this);
	}
}
