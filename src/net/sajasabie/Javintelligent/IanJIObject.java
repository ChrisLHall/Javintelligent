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
	
	
	
}



