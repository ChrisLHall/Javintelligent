import java.util.Random;

package net.sajasabie.Javintelligent;



public class JIWorld {
	
	char map[][] = new char[100][100];
	
	public JIWorld() {
		genWorld();
	}
	
	public JIWorld(int seed) {
	
	}
	
	public JIWorld(char Fx, char Fy, char Sx, char Sy) {

	}
	
	private void genWorld(int seed = 0) {
		if(seed == 0) Random theGen = new Random();
		else Random theGen = new Random(seed);
		
		char x = (char)theGen.nextInt(100);
		char y = (char)theGen.nextInt(100);
		
		map[x][y] = '+';
		
		char x = (char)theGen.nextInt(100);
		char y = (char)theGen.nextInt(100);
		
		map[x][y] = '*';
		
	}
	
	public String toString() {
		String toOut = "";
		for(int i = 0; i < 100; i++) {
			for(int j = 0;j<100;j++) {
				toOut += map[i][j];
			}
			toOut += "\r\n";
		}
		return toOut;
	}

}

