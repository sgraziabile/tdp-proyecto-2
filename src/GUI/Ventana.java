package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private Juego miJuego;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Imagenes\\serpienteLogo.jpg"));
		setTitle("Snake");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarJuego();
			}
		});
		btnJugar.setBounds(166, 114, 89, 23);
		contentPane.add(btnJugar);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRanking();
			}
		});
		btnRanking.setBounds(166, 148, 89, 23);
		contentPane.add(btnRanking);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setBounds(166, 182, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblTitulo = new JLabel("Snake: The Game");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 19));
		lblTitulo.setBounds(112, 59, 190, 32);
		contentPane.add(lblTitulo);

	}
	
	public void actualizarGrafica(EntidadGrafica eg) {
		eg.grafica.setBounds(eg.miEntidad.getX(), eg.miEntidad.getY(), eg.miEntidad.getAlto(), eg.miEntidad.getAncho());
		contentPane.add(eg.grafica);
	}
	public void mostrarRanking() {
		JFrame ranking = new JFrame();
		JLabel aux = new JLabel();
		
		//miJuego.getMiRanking().getJugadores();
		ranking.getContentPane().add(aux);
		ranking.setVisible(true);
		this.setVisible(false);
		
	}
	public void mostrarJuego() {
		JFrame juego = new JFrame();
		
		//miJuego.jugar();
		juego.setVisible(true);
		this.setVisible(false);
		this.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent we) {
				setVisible(true);
				juego.setVisible(false);
			}
		});
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
