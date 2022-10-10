package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.*;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class Ventana extends JFrame {

	private JPanel contentPaneMenu, contentPaneJuego, contentPaneRanking;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes\\serpienteLogo.jpg"));
		setTitle("Snake");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 360);
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBackground(new Color(189, 183, 107));
		contentPaneMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneMenu.setLayout(null);
		setContentPane(contentPaneMenu);
		
		contentPaneRanking = new JPanel();
		contentPaneRanking.setBackground(new Color(189, 183, 107));
		contentPaneRanking.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneRanking.setLayout(null);
		
		contentPaneJuego = new JPanel();
		contentPaneJuego.setBackground(new Color(124, 252, 0));
		contentPaneJuego.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneJuego.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarJuego();
			}
		});
		btnJugar.setBounds(232, 152, 114, 33);
		contentPaneMenu.add(btnJugar);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRanking();
			}
		});
		btnRanking.setBounds(232, 192, 114, 33);
		contentPaneMenu.add(btnRanking);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setBounds(232, 229, 114, 33);
		contentPaneMenu.add(btnSalir);
		
		JLabel lblTitulo2 = new JLabel("The Game");
		lblTitulo2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTitulo2.setBounds(232, 95, 114, 46);
		contentPaneMenu.add(lblTitulo2);
		
		JLabel lblTituloSnake = new JLabel("Snake:");
		lblTituloSnake.setBounds(232, 60, 75, 46);
		lblTituloSnake.setFont(new Font("Verdana", Font.BOLD, 20));
		contentPaneMenu.add(lblTituloSnake);
		
		miJuego = new Juego(this);
		
	}
	
	public void mostrarRanking() {
		contentPaneMenu.setVisible(false);
		contentPaneRanking.setVisible(true);
		setContentPane(contentPaneRanking);
		
		setLblRanking(contentPaneRanking);
		botonVolver(contentPaneRanking);
		
	}
	
	public void mostrarJuego() {
		contentPaneMenu.setVisible(false);
		contentPaneJuego.setVisible(true);
		contentPaneJuego.addKeyListener(new ListenerDireccion());
		setContentPane(contentPaneJuego);
		miJuego.jugar();		
	}
	
	public void gameOver() {
		//mostrar gameOver
		
		JLabel lblnombre = new JLabel("Ingrese su nombre");
		lblnombre.setFont(new Font("Verdana", Font.BOLD, 20));
		JTextField tfnombre = new JTextField();
		JButton btnAgregarJ = new JButton("Agregar jugador");
		btnAgregarJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.getJugador().setNombre(tfnombre.getText());
				miJuego.getMiRanking().agregarJugador(miJuego.getJugador());
			}
		});
		contentPaneJuego.add(lblnombre);
		contentPaneJuego.add(tfnombre);
		contentPaneJuego.add(btnAgregarJ);
	
		setLblRanking(contentPaneJuego);
		botonVolver(contentPaneJuego);
		
	}
	
	public void actualizarGrafica(EntidadGrafica eg) {
		eg.grafica.setBounds(eg.miEntidad.getX(), eg.miEntidad.getY(), eg.miEntidad.getAlto(), eg.miEntidad.getAncho());
		
		
		contentPaneJuego.add(eg.grafica);
	}
	
	public void borrarGrafica(EntidadGrafica eg) {
		contentPaneJuego.remove(eg.grafica);
	}
	
	private void botonVolver(JPanel panel) {
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(232, 230, 114, 33);
		btnVolver.setVisible(true);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPaneMenu.setVisible(true);
				panel.setVisible(false);
				setContentPane(contentPaneMenu);
			}
		});
	}
	
	private void setLblRanking(JPanel panel) {
		Jugador[] ranking = miJuego.getMiRanking().getJugadores();
		JLabel top5 = new JLabel("TOP 5");
		//cambiar bounds
		JLabel jugadores = new JLabel(""+ranking[0]+"\n"+ranking[1]+"\n"+ranking[2]+"\n"+ranking[3]+"\n"+ranking[4]+"\n");
		jugadores.setBounds(244, 205, 89, 23);
		panel.add(jugadores);
		panel.add(top5);
	}
}
