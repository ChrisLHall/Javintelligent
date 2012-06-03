package net.sajasabie.Javintelligent;

import java.util.Random;



public class JIWorld {
	
	char map[][] = new char[100][100];
	double currentPos[] = new double[2];
	double endPos[] = new double[2];
	
	public JIWorld() {
		genWorld(0);
	}
	
	public JIWorld(int seed) {
	
	}
	
	public JIWorld(char Fx, char Fy, char Sx, char Sy) {

	}
	
	private void genWorld(int seed) {
		Random theGen = new Random();
		//else Random theGen = new Random(seed);
		
		currentPos[0] = theGen.nextDouble();
		currentPos[1] = theGen.nextDouble();
		
		map[(int)(currentPos[0]*100)][(int)(currentPos[1]*100)] = '+';
		
		endPos[0] = theGen.nextDouble();
		endPos[1] = theGen.nextDouble();
		
		map[(int)(endPos[0]*100)][(int)(endPos[1]*100)] = '*';
		
	}
	
	public double move(double Mx, double My) {
		if(Mx*Mx < .01*.01 || My*My < .01*.01 || Mx*Mx > 1.0 || My*My > 1.0) return 2.0;
		double oldDist = Math.sqrt((currentPos[0]-endPos[0])*(currentPos[0]-endPos[0]) + (currentPos[1]-endPos[1])*(currentPos[0]-endPos[0]));
		
		
		map[(int)(currentPos[0]*100)][(int)(currentPos[1]*100)] = 0;
		currentPos[0] += Mx;
		currentPos[1] += My;
		if(currentPos[0] > 1.0 || currentPos[0] < 0.0 || currentPos[1] > 1.0 || currentPos[1] < 0.0) {
			currentPos[0] -= Mx;
			currentPos[1] -= My;
			map[(int)(currentPos[0]*100)][(int)(currentPos[1]*100)] = '+';
			return 3.0;
		}
		
		map[(int)(currentPos[0]*100)][(int)(currentPos[1]*100)] = '+';
		
		return oldDist - Math.sqrt((currentPos[0]-endPos[0])*(currentPos[0]-endPos[0]) + (currentPos[1]-endPos[1])*(currentPos[0]-endPos[0]));
	}
	
	public String toString() {
		String toOut = "";
		for(int i = 0; i < 100; i++) {
			for(int j = 0;j<100;j++) {
				if(map[i][j] != 0)toOut += map[i][j];
				else toOut += '-';
			}
			toOut += "\r";
		}
		toOut += "Current position:\r\t";
		toOut += currentPos[0];
		toOut += "\r\t";
		toOut += currentPos[1];
		toOut += "\rGoal:\r\t";
		toOut += endPos[0];
		toOut += "\r\t";
		toOut += endPos[1];
		return toOut;
	}

}

