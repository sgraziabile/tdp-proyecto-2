package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.Entidad;

public class EntidadGrafica {
	protected JLabel grafica;
	protected String[] rutas;
	protected Entidad miEntidad;
	protected Ventana ventana;
	
	public EntidadGrafica() {
		grafica = new JLabel();
		rutas = new String[] {"Azul","Roja","Verde","Banana","Manzana", "Sandia","Uva", "Frutilla", "Pared", "Cabeza", "Cola" };
		//poner la ruta a cada imagen, NO CAMBIAR EL ORDEN DE LAS COSAS
		//src/Imagenes/azul.jpg por ejemplo
	}
	
	public void setImagen(int i) {
		ImageIcon image = new ImageIcon(this.getClass().getResource(this.rutas[i]));
		image.setImage(image.getImage());
		grafica.setIcon(image);
	}
	
	public JLabel getImage() {
		return grafica;
	}
	
	public void actualizarGrafica() {
		ventana.actualizarGrafica(this);
	}
	
	public void borrarGrafica() {
		ventana.borrarGrafica(this);
	}
}
