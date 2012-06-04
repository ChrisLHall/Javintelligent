package net.sajasabie.Javintelligent;

public class JIVisionRequest {
	public double viewAngle = Math.PI*2;
	public double direction = 0.0;
	public JIVisionElements viewArray[] = {JIVisionElements.NONE,JIVisionElements.PLAYER,JIVisionElements.NONE,
		JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.PLAYER,JIVisionElements.PLAYER,JIVisionElements.PLAYER};
	
	
	public JIVisionRequest() {
	
	}
	
	public JIVisionRequest(double vA, double d) {
		this.viewAngle = vA;
		this.direction = d;
	}
}