package frog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener {

	Froggy froggy;
	Froggy frogs[] = new Froggy[10];
	Font big = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);
	Font biggest = new Font("Courier New", 1, 80);
	//Image background;
	//background = getImage("pixil-frame-0 (1).png");
	// ****************************paint
	// method******************************************
	public void paint(Graphics g) {

		super.paintComponent(g);
		froggy.paint(g);
		//background.paint(g);

	}
	public void update() {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() { 
		JFrame f = new JFrame();
		// f.setTitle("Frogger");
		f.setSize(600, 600);
		f.setResizable(false);
		f.addKeyListener(this);
		froggy = new Froggy();
		for (int i = 0; i < frogs.length; i++) {
			frogs[i] = new Froggy();
			frogs[i].setX(i*50);
		}
	
		f.addMouseListener(this);
		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		
		froggy.methodHop();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * turn off velocity for Frog if you don't want it moving when you have stopped
		 * pressing the keys
		 */

		// do the same thing for the other keys
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}