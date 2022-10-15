package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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

	private JPanel contentPaneMenu, contentPaneJuego, contentPaneRanking, panelPuntTiempo ;
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
					if(cambioDireccion(miJuego.getDireccion(), 1))
						miJuego.setDireccion(1);
		        }
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(cambioDireccion(miJuego.getDireccion(), 2))
						miJuego.setDireccion(2);
		        }
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(cambioDireccion(miJuego.getDireccion(), 3))
						miJuego.setDireccion(3);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(cambioDireccion(miJuego.getDireccion(), 4))
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
	

		JButton btnJugar = new JButton("Jugar");
		
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarJuego();
			}
		});
		btnJugar.setBounds(210, 230, 190, 60);
		contentPaneMenu.add(btnJugar);
		
		
		JLabel lblTitulo2 = new JLabel("The Game");
		lblTitulo2.setFont(new Font("Verdana", Font.BOLD, 25));
		lblTitulo2.setBounds(208, 95, 165, 82);
		contentPaneMenu.add(lblTitulo2);
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
		tfPuntuacion.setText("");
		tfPuntuacion.setBackground(Color.GRAY);
		tfPuntuacion.setForeground(Color.BLACK);
		tfPuntuacion.setEditable(false);
		panelPuntTiempo.add(tfPuntuacion);
		tfPuntuacion.setColumns(10);
		
		JLabel lblTimer = new JLabel("Tiempo:");
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelPuntTiempo.add(lblTimer);
		
		tfTimer = new JTextField();
		tfTimer.setText("0");
		tfTimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfTimer.setBackground(Color.GRAY);
		tfTimer.setForeground(Color.BLACK);
		tfTimer.setEditable(false);
		panelPuntTiempo.add(tfTimer);
		tfTimer.setColumns(10);
		
		miJuego = new Juego(this);
		
	}
	
	public void mostrarRanking() {
		contentPaneMenu.setVisible(false);
		contentPaneRanking.setVisible(true);
		setContentPane(contentPaneRanking);
		
		setLblRanking(contentPaneRanking,new Color(189, 183, 107));
		botonVolver(contentPaneRanking, contentPaneRanking);
		
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
		terminarJuego("¡GAME OVER!");
	}
	
	public void actualizarGrafica(EntidadGrafica eg) {
		eg.grafica.setBounds(eg.miEntidad.getX(), eg.miEntidad.getY(), eg.miEntidad.getAlto(), eg.miEntidad.getAncho());
		tfPuntuacion.setText(""+miJuego.getJugador().getPuntuacion());
		contentPaneJuego.add(eg.grafica);
		contentPaneJuego.repaint();
	}
	
	public void borrarGrafica(EntidadGrafica eg) {
		contentPaneJuego.remove(eg.grafica);
		contentPaneJuego.repaint();
	}
	
	private void botonVolver(JPanel panel, JPanel ranking) {
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(210, 430, 190, 60);
		btnVolver.setVisible(true);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPaneMenu.setVisible(true);
				panel.setVisible(false);
				ranking.setVisible(false);
				panel.remove(ranking);
				setContentPane(contentPaneMenu);
			}
		});
	}
	
	private JPanel setLblRanking(JPanel panel, Color c) {
		JPanel panelRanking = crearPanelRanking();
		JLabel top5 = new JLabel("TOP 5");
		top5.setFont(new Font("Verdana", Font.BOLD, 25));
		top5.setBounds(60, 35, 90, 82);
		panelRanking.setBackground(c);
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
		
		jug1.setBounds(25, 100, 190, 30);
		jug2.setBounds(25, 135, 190, 30);
		jug3.setBounds(25, 170, 190, 30);
		jug4.setBounds(25, 205, 190, 30);
		jug5.setBounds(25, 240, 190, 30);

		panelRanking.add(jug1);
		panelRanking.add(jug2);
		panelRanking.add(jug3);
		panelRanking.add(jug4);
		panelRanking.add(jug5);
		panelRanking.add(top5);
		panelRanking.setVisible(true);
		
		panel.add(panelRanking);
		return panelRanking;
	}
	public JTextField getCrono() {
		return tfTimer;
	}
	
	private boolean cambioDireccion(int ant, int nueva) {
		switch (ant) {
			case 1: if(nueva == 3) return false; break; 
			case 2:	if(nueva == 4) return false; break;
			case 3: if(nueva == 1) return false; break;
			case 4: if(nueva == 2) return false; break;
			default: return true;
		}
		return true;
	}
	public JLabel setLblNivel(int i) {
		JLabel lblNivel = new JLabel("¡Nivel "+i+"!");
		lblNivel.setBounds(218, 169, 182, 39);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 39));
		contentPaneJuego.add(lblNivel);
		return lblNivel;
	}
	
	public void borrarLblNivel(JLabel lblNivel) {
		contentPaneJuego.remove(lblNivel);
	}
	public JPanel crearPanelRanking() {
		JPanel panelRanking = new JPanel();
		panelRanking.setBounds(190, 90, 230, 300);
		panelRanking.setBackground(new Color(200, 183, 107));
		panelRanking.setLayout(null);
		
		return panelRanking;
	}
	
	public void ganar() {
		terminarJuego("¡GANASTE!");
	}
	
	private void terminarJuego(String s) {
		JPanel panelRanking = crearPanelRanking();
		JLabel lblgameOver = new JLabel(s);
		lblgameOver.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblgameOver.setBounds(210, 170, 190, 39);
		contentPaneJuego.add(lblgameOver);
		
		JButton btnAgregarJ = new JButton("Agregar jugador");
		btnAgregarJ.setBounds(210, 330, 190, 60);
		btnAgregarJ.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPaneJuego.add(btnAgregarJ);
		btnAgregarJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
				miJuego.getJugador().setNombre(nombre);
				miJuego.getMiRanking().agregarJugador(miJuego.getJugador());
				if(miJuego.getJugador().getNombre() != "") {
					lblgameOver.setVisible(false);
					btnAgregarJ.setVisible(false);
					JPanel rank =setLblRanking(contentPaneJuego, new Color(124, 252, 0));
					botonVolver(contentPaneJuego, rank);
					contentPaneJuego.repaint();
					}
			}
		});
		contentPaneJuego.add(lblgameOver);
		contentPaneJuego.add(btnAgregarJ);
		contentPaneJuego.remove(panelRanking);
		contentPaneRanking.remove(panelRanking);
		panelRanking = null;
		
	}
}
