package net.sajasabie.Javintelligent;

import java.lang.Math;

public class ChrisJIObject extends JIObject{
	
	private boolean moving;
	
	private double direction; //direction in radians
	private double dirChangeFactor;
	
	private double changePerStep;
	private boolean foundCoarseChange;
	private boolean foundFineChange;
	
	private boolean closingInFlag;
	private boolean passedTheGoal;
	private boolean searching;
	private int exitSearchTimer;
	
	private int sucksTimer = 150;
	
	private double persistent_accuracy = 50000;
	private double persistent_accuracy_change = 10000;
	private boolean just_updated_accuracy = false;
	private boolean won_last_game = false;
	
	private double fastest_discovered_speed = 0.1;
	
	private double lastStepChange;
	
	public ChrisJIObject() {
		super();
		this.initVariables();
		//initiate movement in a rightward fashion
		this.setDelta(this.changePerStep, 0);
	}
	
	public void initVariables() {
		if(won_last_game) {
			persistent_accuracy -= persistent_accuracy_change;
			just_updated_accuracy = true;
		} else if(just_updated_accuracy){
			persistent_accuracy += persistent_accuracy_change*1.05;
			persistent_accuracy_change *= 0.5;
		}
		
		moving = true;
		
		direction = 0.0d; //direction in radians
		dirChangeFactor = 1.5;
		
		changePerStep = 0.012;
		foundCoarseChange = false;
		foundFineChange = false;
		
		closingInFlag = false;
		passedTheGoal = false;
		searching = false;
		exitSearchTimer = 10;
		
		sucksTimer = 150;
		
		won_last_game = false;
		
		lastStepChange = 100d;
	}
	
	@Override
	public void update() {
		//runs every time just before moving
		//look at results from last time
		JIErrors temperror = this.getError();
		//remember that for change, POSITIVE IS GOOD
		double tempfeedback = this.getChange();
		//System.out.println("ChrisBot: " + tempfeedback);
		//System.out.println("ChrisBot Telemetry: Direction=" + direction + " , Change factor=" + dirChangeFactor);
		//System.out.println("Move per step:" + changePerStep);
		//do all change logic
		if(temperror == JIErrors.YOUWIN) {
			System.out.println("Chris' bot hit the exit!");
			won_last_game = true;
			//assume that a new world was created
			this.initVariables();
		} else if(temperror == JIErrors.YOULOSE) {
			won_last_game = false;
			this.initVariables();
		} else if(temperror == JIErrors.TOOFAR){
			if(!foundCoarseChange) {
				changePerStep -= 0.001;
				foundCoarseChange = true;
			} else {
				changePerStep -= 0.001;
				if(fastest_discovered_speed >= changePerStep) fastest_discovered_speed = changePerStep;
				foundFineChange = true;
				foundCoarseChange = true;
			}
			System.out.println("TOOFAR*************************************************" + changePerStep);
		} else if(temperror == JIErrors.OOB){
			searching = true;
			changePerStep /= 2;
		} else if(temperror == JIErrors.NONE){
			//Start increasing speed if it is headed ~straight towards target
			if(Math.abs(tempfeedback-changePerStep) < changePerStep/persistent_accuracy || closingInFlag == true) {
				//System.out.println("Closing in...");
				closingInFlag = true;
				if(!searching) changePerStep = fastest_discovered_speed;
				dirChangeFactor = 0;
			}
			if(closingInFlag && !searching) changePerStep = fastest_discovered_speed;
			//turn around and turn slower if change increased (bad)
			if(tempfeedback < lastStepChange) {
				dirChangeFactor *= -0.25;
			}
			if (tempfeedback < 0) {
				//if change is negative, go the other way
				dirChangeFactor *= -1;
				direction += Math.PI;
				if(closingInFlag) {
					passedTheGoal = true;
					searching = true;
				}
			}
			if (passedTheGoal) {
				passedTheGoal = false;
				changePerStep /= 3;
				dirChangeFactor = 0;
			}
			if (searching) exitSearchTimer -= 1;
			direction += dirChangeFactor;
		} else {
			changePerStep += 0.0005;
			System.out.println("Chris' bot was told that it moved too shortly.");
		}
		while(this.direction > 2*Math.PI) this.direction -= 2*Math.PI;
		sucksTimer -= 1;
		if(sucksTimer <= 0) initVariables();
		if(exitSearchTimer <= 0) initVariables();
		//do the actual change
		if(moving == true){
			this.setDelta(this.changePerStep*Math.cos(this.direction), -this.changePerStep*Math.sin(this.direction));
		}else if(moving == false){
			this.setDelta(0, 0);
		}
		
		if(exitSearchTimer <= 0) this.initVariables();
		
		this.lastStepChange = tempfeedback;
	}
}
