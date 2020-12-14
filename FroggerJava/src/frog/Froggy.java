package frog;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Froggy{
	// attributes of a frog
	private int x, y; // Position of frog
	private int vx, vy;
	private boolean alive; // lives
	private int width; // the size of frog
	private int height;
	private Image img; // image of the frog
	private Image left,right,up,down;

	public Froggy() {
		// assignment statements for attributes
		x = 400;
		y = 500;
		vx = 0;
		vy = 0;
		width = 50;
		height = 50;
		left = getImage("pig.png");
		right = getImage("pig.png");
		up = getImage("pig.png");
		down = getImage("pig.png");
		img = up;
		init(x, y);

	}
	
	/* if filename is provided */
	public Froggy(String fileName) {
		// assignment statements for attributes
		x = 400;
		y = 750;
		vx = 0;
		vy = 0;
		width = 50;
		height = 50;
		img = getImage(fileName);;
		init(x, y);

	}

	public void reset() {
		x = 400;	//reset position
		y = 750;
		img = up;	//reset img
	}


	// gets image and proccess it
	public void move() {
		
		y += vy;
		x += vx;
		tx.setToTranslation(x, y);

	}

	public void hop(int t) {

		tx.setToTranslation(x, y);
		
	}
	
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	// draw the affine transform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		move(); //ask frog to update its location variables
		g2.drawImage(img, tx, null);
		
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Froggy.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	// setters and getters
	public void methodHop() {
		y = -50;
		tx.setToTranslation(x,  y);
	}
	public void setVx(int vx) {
		this.vx = vx;
	}

	public void setVy(int vy) {
		this.vy = vy;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		tx.setToTranslation(x, y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		tx.setToTranslation(x, y);
	}
	
	/* Helper function for collision detection later */
	public Rectangle getRect() {
		Rectangle temp = new Rectangle(x,y,width,height);
		return temp;
	}

}
