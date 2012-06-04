package net.sajasabie.Javintelligent;

import java.util.ArrayList;
import java.util.List;

public class JIVision {
	public JIVision(List<JIObjectHolder> theObjects) {
		for(JIObjectHolder currObj : theObjects) {
			System.out.println(currObj);
			JIVisionElements vA[] = {JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,
				JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE};
			for(JIObjectHolder testObj : theObjects) {
				if(testObj != currObj) {
					double angle = Math.atan((currObj.mY - testObj.mY)/(currObj.mX - testObj.mX));
					int quadrant = 0;
					if(currObj.mY > testObj.mY) {
						if(currObj.mX > testObj.mX) quadrant = 2;
						else quadrant = 3;
					} else {
						if(currObj.mX > testObj.mX) quadrant = 1;
						else quadrant = 0;	
					}
					System.out.println("Test angle " + angle + " Calced angle " + (int)(8- quadrant*2 - Math.abs(Math.round(angle*4/Math.PI))) + testObj.mObject.objectType);
					if((currObj.mY - testObj.mY)*(currObj.mY - testObj.mY) + (currObj.mX - testObj.mX)*(currObj.mX - testObj.mX) < JIGlobals.SIGHT_RANGE*JIGlobals.SIGHT_RANGE)
						vA[(int)(8- quadrant*2 - Math.abs(Math.round(angle*4/Math.PI)))] = testObj.mObject.objectType;
					currObj.mObject.vR.viewArray = vA;
				}
			}
		}
	}
}