package net.sajasabie.Javintelligent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class JIRenderer extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6267431460975432972L;
	
	private List<JIRenderable> mRenderableList;
	
	public JIRenderer() {
		super();
		mRenderableList = new LinkedList<JIRenderable>();
	}
	
	public void paint(Graphics g) {
		//First, call the paint function to clar the screen
		super.paint(g);
		//convert graphics to graphics2d
		Graphics2D g2d = (Graphics2D) g;
		//render all of the JIRenderables currently attached to the screen
		for(JIRenderable renderableObject : this.mRenderableList) {
			g2d.setColor(renderableObject.getDrawColor());
			g2d.fill(renderableObject.getShape());
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
