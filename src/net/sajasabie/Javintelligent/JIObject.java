package net.sajasabie.Javintelligent;

import java.util.Random;

public class JIObject {
	public double dP[] = {0.0,0.0};
	public enum Errors {TOOFAR,TOOSHORT,OUTOFBOUNDS,NONE,YOUWIN};
	public Errors error = Errors.NONE;
	Random moveme = new Random();
	
	
	public JIObject() {
	
	}
	
	public void update() {
		dP[0] = moveme.nextDouble()/10;
		dP[1] = moveme.nextDouble()/10;
	}
	
}