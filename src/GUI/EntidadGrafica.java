package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entidades.Entidad;

public class EntidadGrafica {
	protected ImageIcon grafica;
	protected String[] rutas;
	protected Entidad miEntidad;
	
	public EntidadGrafica() {
		grafica = new ImageIcon();
		rutas = new String[11];
	}
	
	public void setImagen(int i) {
		ImageIcon image = new ImageIcon(this.getClass().getResource(this.rutas[i]));
		grafica.setImage(image.getImage());
	}
	
	public ImageIcon getImage() {
		return grafica;
	}
	
}
