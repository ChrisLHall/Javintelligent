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
	

}