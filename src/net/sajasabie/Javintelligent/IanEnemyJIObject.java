package net.sajasabie.Javintelligent;

public class IanEnemyJIObject extends JIObject {
	
	double lastchanges[] = {0,0,0,0,0,0};
	double lastdeltas[] = {0,0,0};
	
	double dx = 0.0;
	double dy = 0.0;
	double accel = 0.0005;
	double speed = 0.005;
	double maxspeed = 0;
	int state = 0;
	int oobcount = 0;
	//turns
	
	JIErrors lasterrors[] = {JIErrors.NONE,JIErrors.NONE,JIErrors.NONE};
	int turns = 0;
	
	public IanJIObject() {
		super();
	}
	
	@Override
	public void update() {
		turns++;
		System.out.println(error);
		
		if(error == JIErrors.YOUWIN || error == JIErrors.YOULOSE) {
			state = 0;
			System.out.println("\r\r\r\r\r\r\r\r\r");
			oobcount = 0;
			turns = 0;
		}
		if(state == 0) {
			dP[0] = 0;
			dP[1] = 0;
			state++;
			accel = .001;
			turns = 0;
		//	speed = maxspeed - accel*5;
		//	maxspeed = 0;
		} else if(state == 1) {
			dP[0] = .003;
			state++;
		} else if(state == 2) {
			dP[0] = 0;
			dP[1] = .003;
			dx = change;
			state++;
		} else if(state == 3) {
			dP[0] = -.003;
			dP[1] = -.003;
			dy = change;
			state++;
		} else if(state == 4){
			dP[0] = 0;
			dP[1] = 0;
			state++;
		} else if(error == JIErrors.OOB) {
			state = 0;
			oobcount++;
			if(oobcount >= 10) {
				speed = maxspeed - accel;
				maxspeed = 0;
				oobcount = 0;
			}
		} else if(error == JIErrors.TOOFAR) {
			maxspeed = speed-accel;
			accel*=.1;
			state = 0;
		} else {
			if(dy < 0) System.out.println("It's up!");
			else System.out.println("It's down!");
			if(dx > 0) System.out.println("It's right!");
			else System.out.println("It's left!");
			System.out.println(error);
			System.out.println(state);
			System.out.println(change);
			System.out.println(speed);
			double angle = Math.atan(Math.sqrt(dy*dy)/Math.sqrt(dx*dx));
			
			//if(error != JIErrors.TOOFAR && state == 6 && change >= 0) {
				speed += accel;
				if(maxspeed != 0) speed = maxspeed;
				if(change < -.01 && turns > 6) {
					speed*=.75;
					maxspeed = 0;
					dy*=-1;
					dx*=-1;
				}
				dP[1] = Math.sin(angle)*speed*((dy < 0)? -1:1);
				dP[0] = Math.cos(angle)*speed*((dx < 0)? -1:1);
				System.out.println("WARPSPEEEEEED");
		}
	}
	
}



