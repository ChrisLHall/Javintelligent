package net.sajasabie.Javintelligent;

public class JIVision {
	public JIVision(JIObjectHolder theObjects[]) {
		for(JIObjectHolder currObj : theObjects) {
			System.out.println(currObj);
			JIVisionElements vA[] = {JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,
				JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE,JIVisionElements.NONE};
			for(JIObjectHolder testObj : theObjects) {
				if(testObj != currObj) {
					double angle = Math.atan2((currObj.mY - testObj.mY),(currObj.mX - testObj.mX));
					System.out.println("Test angle " + (8-Math.abs(Math.floor(8*(angle/Math.PI)))) + " Calced angle " + angle);
					vA[(int)(8-Math.abs(Math.floor(8*(angle/Math.PI))))] = JIVisionElements.PLAYER;
					currObj.mObject.vR.viewArray = vA;
				}
			}
		}
	}
}