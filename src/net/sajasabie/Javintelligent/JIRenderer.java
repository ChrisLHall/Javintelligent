package net.sajasabie.Javintelligent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JIRenderer extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6267431460975432972L;
	
	private Ellipse2D.Double testCircle;
	private Rectangle2D.Double testSquare;
	
	public JIRenderer() {
		super();
		this.testCircle = new Ellipse2D.Double(200, 200, 10, 10);
		this.testSquare = new Rectangle2D.Double(0,0,600,600);
	}
	
	public void drawWorld(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fill(this.testCircle);
		g2d.draw(testSquare);
	}
}
