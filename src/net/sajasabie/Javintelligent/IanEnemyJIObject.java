package net.sajasabie.Javintelligent;

public class IanEnemyJIObject extends JIObject {
	
	double lastchanges[] = {0,0,0,0,0,0};
	double lastdeltas[] = {0,0,0};
	
	double dx = 0.0;
	double dy = 0.0;
	double accel = 0.0005;
	double speed = 0.01;
	double maxspeed = 0;
	int state = 0;
	int oobcount = 0;
	//turns
	
	JIErrors lasterrors[] = {JIErrors.NONE,JIErrors.NONE,JIErrors.NONE};
	int turns = 0;
	
	public IanEnemyJIObject() {
		super();
	}
	
	@Override
	public void update() {
		int i = 0;
		while(vR.viewArray[i] != JIVisionElements.PLAYER) {
			i++;
		}
		System.out.println("STUFF" + i);
		double angle = -Math.PI*2.0*((i)/8.0);
		
		System.out.println("STUFF" + angle);
		dP[1] = Math.sin(angle)*speed;
		dP[0] = Math.cos(angle)*speed;
	}
	
}



