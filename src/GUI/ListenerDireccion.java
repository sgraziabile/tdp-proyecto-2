package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenerDireccion implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Izquierda");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Derecha");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down");
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
