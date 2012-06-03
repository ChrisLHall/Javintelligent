package net.sajasabie.Javintelligent;

public class JIVisionRequest {
	public double viewAngle = 0.0;
	public double direction = 0.0;
	public JIVisionElements viewArray[] = new JIVisionElements[8];
	
	
	public JIVisionRequest() {
	
	}
	
	public JIVisionRequest(double vA, double d) {
		this.viewAngle = vA;
		this.direction = d;
	}
}