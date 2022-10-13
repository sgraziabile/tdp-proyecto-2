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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Ventana extends JFrame{

	private JPanel contentPaneMenu, contentPaneJuego, contentPaneRanking, panelRanking, panelPuntTiempo ;
	private Juego miJuego;
	private JTextField tfPuntuacion;
	private JTextField tfTimer;

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
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					miJuego.setDireccion(1);
		        }
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					miJuego.setDireccion(2);
		        }
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					miJuego.setDireccion(3);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	miJuego.setDireccion(4);
		        } 
			}
		});
		this.setFocusable(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes\\serpienteLogo.jpg"));
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 30, 620, 700);
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBackground(new Color(189, 183, 107));
		contentPaneMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneMenu.setLayout(null);
		setContentPane(contentPaneMenu);
			
		
		contentPaneRanking = new JPanel();
		contentPaneRanking.setBackground(new Color(189, 183, 107));
		contentPaneRanking.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneRanking.setLayout(null);
	
		panelRanking = new JPanel();
		panelRanking.setBounds(112, 90, 300, 300);
		panelRanking.setBackground(new Color(189, 183, 107));
		panelRanking.setLayout(null);
		contentPaneRanking.add(panelRanking);
		
		JButton btnJugar = new JButton("Jugar");
		
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarJuego();
			}
		});
		btnJugar.setBounds(210, 230, 190, 60);
		contentPaneMenu.add(btnJugar);
		
		JButton btnRanking = new JButton("Ranking");
		
		btnRanking.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRanking();
			}
		});
		btnRanking.setBounds(210, 330, 190, 60);
		contentPaneMenu.add(btnRanking);
		
		JButton btnSalir = new JButton("Salir");
		
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setBounds(210, 430, 190, 60);
		contentPaneMenu.add(btnSalir);
		
		JLabel lblTitulo2 = new JLabel("The Game");
		lblTitulo2.setFont(new Font("Verdana", Font.BOLD, 25));
		lblTitulo2.setBounds(208, 95, 165, 82);
		contentPaneMenu.add(lblTitulo2);
		
		JLabel lblTituloSnake = new JLabel("Snake:");
		lblTituloSnake.setBounds(208, 45, 165, 117);
		lblTituloSnake.setFont(new Font("Verdana", Font.BOLD, 25));
		contentPaneMenu.add(lblTituloSnake);
		
		panelPuntTiempo = new JPanel();
		panelPuntTiempo.setBackground(Color.GRAY);
		panelPuntTiempo.setBounds(0, 612, 604, 100);
		
		JLabel lblPuntuacion = new JLabel("Puntacion:");
		lblPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelPuntTiempo.add(lblPuntuacion);
		
		tfPuntuacion = new JTextField();
		tfPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfPuntuacion.setText("x1");
		tfPuntuacion.setBackground(Color.GRAY);
		tfPuntuacion.setForeground(Color.BLACK);
		panelPuntTiempo.add(tfPuntuacion);
		tfPuntuacion.setColumns(10);
		
		JLabel lblTimer = new JLabel("Tiempo:");
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelPuntTiempo.add(lblTimer);
		
		tfTimer = new JTextField();
		tfTimer.setText("x2");
		tfTimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfTimer.setBackground(Color.GRAY);
		tfTimer.setForeground(Color.BLACK);
		panelPuntTiempo.add(tfTimer);
		tfTimer.setColumns(10);
		
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
		contentPaneJuego = new JPanel();
		contentPaneJuego.setBackground(new Color(124, 252, 0));
		contentPaneJuego.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneJuego.setLayout(null);
		contentPaneJuego.add(panelPuntTiempo);
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
		miJuego.cambiarNivel(1);
		
	}
	
	public void actualizarGrafica(EntidadGrafica eg) {
		eg.grafica.setBounds(eg.miEntidad.getX(), eg.miEntidad.getY(), eg.miEntidad.getAlto(), eg.miEntidad.getAncho());
		contentPaneJuego.add(eg.grafica);
		contentPaneJuego.repaint();
	}
	
	public void borrarGrafica(EntidadGrafica eg) {
		contentPaneJuego.remove(eg.grafica);
		contentPaneJuego.repaint();
	}
	
	private void botonVolver(JPanel panel) {
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(210, 430, 190, 60);
		btnVolver.setVisible(true);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		JLabel top5 = new JLabel("TOP 5");
		top5.setFont(new Font("Verdana", Font.BOLD, 25));
		top5.setBounds(140, 35, 165, 82);
		
		JLabel jug1 = new JLabel(miJuego.getMiRanking().getJugador(1));
		JLabel jug2 = new JLabel(miJuego.getMiRanking().getJugador(2));
		JLabel jug3 = new JLabel(miJuego.getMiRanking().getJugador(3));
		JLabel jug4 = new JLabel(miJuego.getMiRanking().getJugador(4));
		JLabel jug5 = new JLabel(miJuego.getMiRanking().getJugador(5));
		
		jug1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		jug2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		jug3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		jug4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		jug5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		jug1.setBounds(110, 100, 190, 30);
		jug2.setBounds(110, 135, 190, 30);
		jug3.setBounds(110, 170, 190, 30);
		jug4.setBounds(110, 205, 190, 30);
		jug5.setBounds(110, 240, 190, 30);

		panelRanking.add(jug1);
		panelRanking.add(jug2);
		panelRanking.add(jug3);
		panelRanking.add(jug4);
		panelRanking.add(jug5);
		panelRanking.add(top5);
		panel.add(panelRanking);
	}
}
