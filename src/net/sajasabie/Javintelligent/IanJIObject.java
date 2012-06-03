package net.sajasabie.Javintelligent;

public class IanJIObject extends JIObject {
	
	double lastchanges[] = {0,0,0,0,0,0};
	double lastdeltas[] = {0,0,0};
	
	double dx = 0.0;
	double dy = 0.0;
	
	int state = 0;
	
	JIErrors lasterrors[] = {JIErrors.NONE,JIErrors.NONE,JIErrors.NONE};
	int turns = 0;
	
	public IanJIObject() {
		super();
	}
	
	@Override
	public void update() {
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
		}
			if(state == 1 && change < 0) { 
				state = 3;
				}
			switch(state) {
				case 1:
					dP[0] = .005;
					break;
				case 2:
					dP[0] = -.005;
					break;
				case 3:
					dP[0] = -.00005;
					break;
			}
			
		turns++;
	}
	
}



