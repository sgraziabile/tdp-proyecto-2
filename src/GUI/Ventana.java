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


@SuppressWarnings("serial")
public class Ventana extends JFrame{

	private JPanel contentPaneMenu, contentPaneJuego, contentPaneRanking, panelRanking;
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
		setBounds(100, 100, 595, 640);
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
		panelRanking.setBounds(112, 60, 375, 185);
		panelRanking.setBackground(new Color(189, 183, 107));
		panelRanking.setLayout(null);
		contentPaneRanking.add(panelRanking);
		
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
		lblTituloSnake.setBounds(232, 60, 87, 46);
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
		contentPaneJuego = new JPanel();
		contentPaneJuego.setBackground(new Color(124, 252, 0));
		contentPaneJuego.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPaneJuego.setLayout(null);

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
		contentPaneJuego.repaint();
	}
	
	public void borrarGrafica(EntidadGrafica eg) {
		contentPaneJuego.remove(eg.grafica);
		contentPaneJuego.repaint();
	}
	
	private void botonVolver(JPanel panel) {
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(232, 250, 114, 33);
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
		JLabel top5 = new JLabel("TOP 5");
		top5.setFont(new Font("Tahoma", Font.BOLD, 18));
		top5.setBounds(127, 11, 60, 22);
		
		JLabel jug1 = new JLabel(miJuego.getMiRanking().getJugador(1));
		JLabel jug2 = new JLabel(miJuego.getMiRanking().getJugador(2));
		JLabel jug3 = new JLabel(miJuego.getMiRanking().getJugador(3));
		JLabel jug4 = new JLabel(miJuego.getMiRanking().getJugador(4));
		JLabel jug5 = new JLabel(miJuego.getMiRanking().getJugador(5));
		
		jug1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jug2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jug3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jug4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jug5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jug1.setBounds(110, 60, 190, 20);
		jug2.setBounds(110, 80, 190, 20);
		jug3.setBounds(110, 100, 190, 20);
		jug4.setBounds(110, 120, 190, 20);
		jug5.setBounds(110, 140, 190, 20);

		panelRanking.add(jug1);
		panelRanking.add(jug2);
		panelRanking.add(jug3);
		panelRanking.add(jug4);
		panelRanking.add(jug5);
		panelRanking.add(top5);
	}

}
