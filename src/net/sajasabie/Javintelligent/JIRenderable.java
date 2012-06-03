package net.sajasabie.Javintelligent;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class JIRenderable {

	private double mX, mY;
	private RectangularShape mShape;
	private Color mDrawColor;
	
	public JIRenderable(double x, double y, RectangularShape pShape, Color pColor){
		//Creates a new renderable at the given coordinates with the given shape
		//Shape is an object from java.awt.Shape (default is new Ellipse2D.Double(x, y, 20, 20))
		//Color is a color from java.awt.Color (default is Color.RED)
		this.mX = x;
		this.mY = y;
		this.mShape = pShape;
		this.mDrawColor = pColor;
	}
	
	public JIRenderable(double x, double y) {
		this(x, y, new Ellipse2D.Double(x, y, 20, 20), Color.RED);
	}
	
	public void setPosition(double x, double y) {
		this.mX = x;
		this.mY = y;
		this.mShape.setFrame();
	}
}
