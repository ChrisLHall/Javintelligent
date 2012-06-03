package net.sajasabie.Javintelligent;

public class IanJIObject extends JIObject {
	
	double lastchanges[] = {0,0,0,0,0,0};
	double lastdeltas[] = {0,0,0};
	
	double dx = 0.0;
	double dy = 0.0;
	double accel = 0.0005;
	double speed = 0.005;
	double maxspeed = 0;
	int state = 0;
	int oobcount = 0;
	
	JIErrors lasterrors[] = {JIErrors.NONE,JIErrors.NONE,JIErrors.NONE};
	int turns = 0;
	
	public IanJIObject() {
		super();
	}
	
	@Override
	public void update() {
		if(error == JIErrors.YOUWIN) {
			state = 0;
			System.out.println("\r\r\r\r\r\r\r\r\r");
			oobcount = 0;
		}
		if(state == 0) {
			dP[0] = 0;
			dP[1] = 0;
			state++;
			speed = maxspeed - accel*5;
			maxspeed = 0;
		} else if(state == 1) {
			dP[0] = .003;
			state++;
		} else if(state == 2) {
			dP[0] = 0;
			dx = change;
			state++;
		} else if(state == 3) {
			dP[1] = .003;
			state++;
		} else if(state == 4) {
			dP[1] = 0;
			dy = change;
			state++;
		} else if(state == 5){
			dP[0] = -.003;
			dP[1] = -.003;
			state++;
		} else if(state == 5){
			dP[0] = 0;
			dP[1] = 0;
			state++;
		} else if(error == JIErrors.OOB) {
			state = 0;
			oobcount++;
			if(oobcount >= 10) {
				speed = maxspeed - accel*5;
				maxspeed = 0;
				oobcount = 0;
			}
		} else if(error == JIErrors.TOOFAR) {
			maxspeed = speed-accel;
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
				if(change < -.00001) state = 0;
				dP[1] = Math.sin(angle)*speed*((dy < 0)? -1:1);
				dP[0] = Math.cos(angle)*speed*((dx < 0)? -1:1);
				System.out.println("WARPSPEEEEEED");
		}
		
		
		
		
	/*
		if(error == JIErrors.YOUWIN || error == JIErrors.YOULOSE) turns = 0;
		
		
		System.out.println("Ian change: \t" + change + "\t State: " + state + "\rDx: \t" + dx + "\tDy\t" +dy);
		for(int i = 5; i > 1; i-=2) {
			lastchanges[i] = lastchanges[i-2];
			lastchanges[i-1] = lastchanges[i-3];
		}
		for(int i = 0; i > 0; i--) lastdeltas[i] = lastdeltas[i-1]; 
		for(int i = 0; i > 0; i--) lasterrors[i] = lasterrors[i-1]; 
		if(turns == 0) dP[0] = .005;  
		else if(turns == 1) {
			dP[1] = .005;  
			dx = change;
			System.out.println("Dx " + dx);
			}
		else if(turns == 2) {
			//dP[1] = .005; 
			dy = change;			
			System.out.println("Dy" + dy);
		} else if(turns == 3) {
			state = 1;
			dP[1] = 0;
			if(dx < 0) state = 2; 
			change = 0;
		}
		if((state == 1 ||state == 2) && change < 0) { 
			dP[0] = 0;
			state = 5;
			dP[1] = .005;
			//if(dy > 0) state = 4;
		}
		if(state == 5) {
			state = 3;
			if(change > 0) state = 3;
		}
		switch(state) {
			case 1:
				dP[0] = .005;
				break;
			case 2:
				dP[0] = -.005;
				break;
			case 3:
				dP[1] = -.005;
				break;
			case 4:
				dP[1] = .005;
				break;
				
		}
			
		turns++;*/
	}
	
}



