package net.sajasabie.Javintelligent;

import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.Color;


public class JIWorld {
	
	int score[] = new int[2];
	double goalX, goalY;
	JIRenderable goal;
	JIObjectHolder IanBot, ChrisBot;
	int turns = 0;
	int round = 0;
	Random theGen = new Random();
	
	public JIWorld() {
		
		IanBot = new JIObjectHolder(new IanJIObject(), new JIRenderable(new Ellipse2D.Double(0,0,15,15), Color.YELLOW));
		ChrisBot = new JIObjectHolder(new ChrisJIObject(), new JIRenderable(new Ellipse2D.Double(0,0,15,15), Color.RED));
		goal = new JIRenderable(new Ellipse2D.Double(0,0,20,20), Color.GREEN);
		JIApplication.getRenderer().attach(goal);
		genWorld(theGen.nextInt());
		
	}
	
	public JIWorld(int seed) {
		this();
		theGen = new Random(seed);
	}
	
	public JIWorld(char Fx, char Fy, char Sx, char Sy) {
		this();
	}
	
	
	
	
	private void genWorld(int seed) {
		System.out.println(seed);
		//else Random theGen = new Random(seed);
		double startx = theGen.nextDouble();
		double starty = theGen.nextDouble();
		IanBot.setPosition(startx, starty);
		ChrisBot.setPosition(startx, starty);
		goalX = theGen.nextDouble();
		goalY = theGen.nextDouble();
		goal.setPosition(goalX*600, goalY*600);
	}
	
	public void onStep() {
		ChrisBot.onMoveUpdate();
		IanBot.onMoveUpdate();
		this.move(ChrisBot, 0);
		this.move(IanBot, 2);
		ChrisBot.onRenderableUpdate();
		IanBot.onRenderableUpdate();
		System.out.println("Chris: \t" + score[0] + "\tIan: \t" + score[1]);
		if(ChrisBot.getObject().getError() == JIErrors.YOUWIN || IanBot.getObject().getError() == JIErrors.YOUWIN) {
			genWorld(theGen.nextInt());
		}
	}
	
	public void move(JIObjectHolder theBot, int offset) {
		double Mx = theBot.getObject().getDX(); 
		double My = theBot.getObject().getDY();
		System.out.println(Mx*Mx + " " + My*My);
		theBot.getObject().setError(JIErrors.NONE);
		
		if(Mx*Mx + My*My > .005) {
			theBot.getObject().setError(JIErrors.TOOFAR);
			return;
		}
		double oldDist = Math.sqrt((theBot.getX()-goalX)*(theBot.getX()-goalX) + (theBot.getY()-goalY)*(theBot.getY()-goalY));
		
		if(theBot.getX() + Mx > 1.0 || theBot.getX() + Mx < 0.0 || theBot.getY() + My > 1.0 || theBot.getY() + My < 0.0) {
			theBot.getObject().setError(JIErrors.OOB);
			return;
		} else {
			theBot.setPosition(theBot.getX() + Mx, theBot.getY() + My);
		}
		
		if(Math.sqrt((theBot.getX()-goalX)*(theBot.getX()-goalX) + (theBot.getY()-goalY)*(theBot.getY()-goalY)) < .0166) {
			IanBot.getObject().setError(JIErrors.YOULOSE);
			ChrisBot.getObject().setError(JIErrors.YOULOSE);
			theBot.getObject().setError(JIErrors.YOUWIN);
			score[offset/2] +=1;
			//genWorld(theSeed.nextInt());
		}
		
		theBot.getObject().setChange(oldDist - Math.sqrt((theBot.getX()-goalX)*(theBot.getX()-goalX) + (theBot.getY()-goalY)*(theBot.getY()-goalY)));
	}

}

