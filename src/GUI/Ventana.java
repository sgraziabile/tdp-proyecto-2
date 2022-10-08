package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joaquin\\Documents\\UML tdp\\tdp-proyecto-2\\src\\Imagenes\\serpienteLogo.jpg"));
		setTitle("Snake");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
	
	public void actualizarGrafica(EntidadGrafica eg) {
		eg.grafica.setBounds(eg.miEntidad.getX(), eg.miEntidad.getY(), eg.miEntidad.getAlto(), eg.miEntidad.getAncho());
		contentPane.add(eg.grafica);
	}
	public void mostrarRanking() {
		
	}
	public void mostrarJuego() {
	
	}
	public void gameOver() {
		JLabel lblGO = new JLabel();
		lblGO.setIcon(null);
		contentPane.add(lblGO);
	}
	
	public void borrarGrafica(EntidadGrafica eg) {
		contentPane.remove(eg.grafica);
	}
}
