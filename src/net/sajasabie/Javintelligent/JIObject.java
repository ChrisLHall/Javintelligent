package net.sajasabie.Javintelligent;

import java.util.Random;

public class JIObject {
	public double dP[] = {0.0,0.0};
	public double change = 0.0;
	public JIErrors error = JIErrors.NONE;
	Random moveme = new Random();
	
	
	public JIObject() {
		
	}
	
	public void update() {
		dP[0] = (moveme.nextDouble()-.5)/2;
		dP[1] = (moveme.nextDouble()-.5)/2;
		System.out.println(error);
	}
	
	public double getDX() {
		return this.dP[0];
	}
	
	public double getDY() {
		return this.dP[1];
	}
	
	public void setDelta(double dX, double dY) {
		this.dP[0] = dX;
		this.dP[1] = dY;
	}
	
	public void setChange(double newchange) {
		this.change = newchange;
	}
	
	public double getChange() {
		return this.change;
	}
	
	public void setError(JIErrors newerror) {
		this.error = newerror;
	}
	
	public JIErrors getError(){
		return this.error;
	}

}