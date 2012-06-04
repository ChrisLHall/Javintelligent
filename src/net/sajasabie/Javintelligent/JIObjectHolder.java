package net.sajasabie.Javintelligent;

public class JIObjectHolder {
	public IBaseObject mObject;
	public JIRenderable mRenderable;
	public double mX = 0;
	public double mY = 0;
	
	public JIObjectHolder(IBaseObject contents ,  JIRenderable contentRenderable) {
		this.mObject = contents;
		this.mRenderable = contentRenderable;
		if(this.mRenderable != null) JIApplication.getRenderer().attach(this.mRenderable);
	}
	
	public void onMoveUpdate() {
		if(this.mObject != null) this.mObject.update();
	}
	
	public void onRenderableUpdate() {
		if(this.mRenderable != null) this.mRenderable.setPosition(this.getX()*600, this.getY()*600);
	}
	
	public void setPosition(double pX, double pY) {
		this.mX = pX;
		this.mY = pY;
	}
	
	public void setX(double pX) {
		this.setPosition(pX, this.getY());
	}
	
	public void setY(double pY) {
		this.setPosition(this.getX(), pY);
	}
	
	public double getX() {
		return this.mX;
	}
	
	public double getY() {
		return this.mY;
	}
	
	public IBaseObject getObject() {
		return this.mObject;
	}
	
	public JIRenderable getRenderable() {
		return this.mRenderable;
	}
	
}
