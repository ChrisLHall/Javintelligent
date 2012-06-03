package net.sajasabie.Javintelligent;

import java.lang.Math;

public class ChrisJIObject extends JIObject{
	
	private boolean moving;
	
	private double direction; //direction in radians
	private double dirChangeFactor;
	
	private double changePerStep = 0.003;
	private boolean foundMaxChange = false;
	
	private double lastStepChange = 100d;
	
	public ChrisJIObject() {
		super();
		//initiate movement in a rightward fashion
		this.moving = true;
		this.direction = 0.0d;
		this.dirChangeFactor = 0.1;
		this.setDelta(this.changePerStep, 0);
	}
	
	@Override
	public void update() {
		//runs every time just before moving
		//look at results from last time
		JIErrors temperror = this.getError();
		//remember that for change, NEGATIVE IS GOOD
		double tempfeedback = this.getChange();
		
		//do all change logic
		if(temperror == JIErrors.YOUWIN) {
			System.out.println("Chris' bot hit the exit!");
			moving = false;
		} else if(temperror == JIErrors.TOOFAR){
			changePerStep -= 0.0005;
			foundMaxChange = true;
		} else if(temperror == JIErrors.OOB){
			direction += dirChangeFactor;
		} else if(temperror == JIErrors.NONE){
			//THE BULK OF THE CODE
			if(!foundMaxChange) changePerStep += 0.0005;
			/*if(Math.abs(this.tempfeedback - this.lastStepChange) < 0.001 ) {
				if()
			}*/
		} else {
			changePerStep += 0.0005;
			System.out.println("Chris' bot was told that it moved too shortly.");
		}
		while(this.direction > 2*Math.PI) this.direction -= 2*Math.PI;
		
		//do the actual change
		if(this.moving){
			this.setDelta(this.changePerStep*Math.cos(this.direction), -this.changePerStep*Math.sin(this.direction));
		}else{
			this.setDelta(0, 0);
		}
		
		this.lastStepChange = tempfeedback;
	}
}
