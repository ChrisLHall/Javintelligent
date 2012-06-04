package net.sajasabie.Javintelligent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class JIRenderer extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6267431460975432972L;
	
	private List<JIRenderable> mRenderableList;
	private final Rectangle2D.Double boundingrect = new Rectangle2D.Double(1,1,600,600);
	
	public JIRenderer() {
		super();
		mRenderableList = new LinkedList<JIRenderable>();
	}
	
	public void paint(Graphics g) {
		//First, call the paint function to clar the screen
		super.paint(g);
		//convert graphics to graphics2d
		Graphics2D g2d = (Graphics2D) g;
		//render a bounding box
		g2d.setColor(Color.BLACK);
		g2d.draw(boundingrect);
		//render all of the JIRenderables currently attached to the screen
		for(JIRenderable renderableObject : this.mRenderableList) {
			if(renderableObject.isVisible()) {
				g2d.setColor(renderableObject.getDrawColor());
				g2d.fill(renderableObject.getShape());
			}
		}
	}
	
	public void attach(JIRenderable child) {
		this.mRenderableList.add(child);
	}
	
	public void detach(JIRenderable child) {
		this.mRenderableList.remove(child);
	}
	
	public void detachAll() {
		this.mRenderableList.clear();
	}
	
	public void destroy() {
		this.detachAll();
	}
}
