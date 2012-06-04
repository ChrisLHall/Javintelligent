package net.sajasabie.Javintelligent;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class JIRenderable {
	
	private RectangularShape mShape;
	private Color mDrawColor;
	private boolean visible;
	
	public JIRenderable(RectangularShape pShape, Color pColor){
		//Creates a new renderable at the given coordinates with the given shape
		//pShape is an object from java.awt.geom.RectangularShape (default is new Ellipse2D.Double(x, y, 20, 20))
		//pColor is a color from java.awt.Color (default is Color.RED)
		this.mShape = pShape;
		this.mDrawColor = pColor;
		this.visible = true;
	}
	
	public JIRenderable(double x, double y) {
		this(new Ellipse2D.Double(x, y, 20, 20), Color.RED);
	}
	
	public void setPosition(double x, double y) {
		this.mShape.setFrame(x, y, this.mShape.getWidth(), this.mShape.getHeight());
	}
	
	public void setShape(RectangularShape pShape) {
		this.mShape = pShape;
	}
	
	public RectangularShape getShape() {
		return this.mShape;
	}
	
	public Color getDrawColor() {
		return this.mDrawColor;
	}
	
	public double getX() {
		return this.mShape.getX();
	}
	
	public double getY() {
		return this.mShape.getY();
	}
	
	public double getWidth() {
		return this.mShape.getWidth();
	}
	
	public double getHeight() {
		return this.mShape.getHeight();
	}
	
	public void setVisible(boolean vis) {
		this.visible = vis;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
}
