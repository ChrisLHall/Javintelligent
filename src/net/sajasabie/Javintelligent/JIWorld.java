package net.sajasabie.Javintelligent;

import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.Color;


public class JIWorld extends JIWorldBase{
	
	int score[] = new int[2];
	double goalX, goalY;
	JIRenderable goal;
	JIObjectHolder IanBot, ChrisBot;
	int turns = 0;
	int round = 0;
	Random theGen = new Random();
	
	public JIWorld() {
		super();
		IanBot = new JIObjectHolder(new IanJIObject(), new JIRenderable(new Ellipse2D.Double(0,0,15,15), Color.YELLOW));
		this.mObjectHolders.add(IanBot);
		ChrisBot = new JIObjectHolder(new ChrisJIObject(), new JIRenderable(new Ellipse2D.Double(0,0,15,15), Color.RED));
		this.mObjectHolders.add(ChrisBot);
		goal = new JIRenderable(new Ellipse2D.Double(0,0,20,20), Color.GREEN);
		JIApplication.getRenderer().attach(goal);
		genWorld(theGen.nextInt());
		
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
	
	@Override
	public void onStep() {
		super.onStep();
		this.checkForWins();
		System.out.println("Chris: \t" + score[0] + "\tIan: \t" + score[1]);
		if(ChrisBot.getObject().getError() == JIErrors.YOUWIN || IanBot.getObject().getError() == JIErrors.YOUWIN) {
			genWorld(theGen.nextInt());
		}
	}
	
	@Override
	public void simulate(JIObjectHolder theBot) {
		super.simulate(theBot);
		double Mx = theBot.getObject().getDX(); 
		double My = theBot.getObject().getDY();
		theBot.getObject().setError(JIErrors.NONE);
		
		if(Mx*Mx + My*My > .005) {
			theBot.getObject().setError(JIErrors.TOOFAR);
			return;
		}
		double oldDist = JIGlobals.distance(theBot.getX(), theBot.getY(), goalX, goalY);
		
		if(theBot.getX() + Mx > 1.0 || theBot.getX() + Mx < 0.0 || theBot.getY() + My > 1.0 || theBot.getY() + My < 0.0) {
			theBot.getObject().setError(JIErrors.OOB);
			return;
		} else {
			theBot.setPosition(theBot.getX() + Mx, theBot.getY() + My);
		}
		
		theBot.getObject().setChange(oldDist - Math.sqrt((theBot.getX()-goalX)*(theBot.getX()-goalX) + (theBot.getY()-goalY)*(theBot.getY()-goalY)));
	}
	
	public void checkForWins() {
		boolean foundwinner = false;
		if(JIGlobals.distance(IanBot.getX(), IanBot.getY(), goalX, goalY) < 0.0166) {
			IanBot.getObject().setError(JIErrors.YOUWIN);
			score[1] += 1;
			foundwinner = true;
		}
		if(JIGlobals.distance(ChrisBot.getX(), ChrisBot.getY(), goalX, goalY) < 0.0166) {
			ChrisBot.getObject().setError(JIErrors.YOUWIN);
			score[0] += 1;
			foundwinner = true;
		}
		if(foundwinner) {
			if(ChrisBot.getObject().getError() != JIErrors.YOUWIN) ChrisBot.getObject().setError(JIErrors.YOULOSE);
			if(IanBot.getObject().getError() != JIErrors.YOUWIN) IanBot.getObject().setError(JIErrors.YOULOSE);
		}
		
	}

}

