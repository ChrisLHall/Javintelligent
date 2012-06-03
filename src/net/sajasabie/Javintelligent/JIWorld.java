package net.sajasabie.Javintelligent;

import java.util.Random;




public class JIWorld {
	
	char map[][] = new char[100][100];
	
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
		
		int x = theGen.nextInt(100);
		int y = theGen.nextInt(100);
		
		map[x][y] = '+';
		
		x = theGen.nextInt(100);
		y = theGen.nextInt(100);
		
		map[x][y] = '*';
		
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
		return toOut;
	}

}

