package net.sajasabie.Javintelligent;



public class JIWorldTest {
	public static void main(String[] argv) {
		JIWorld theWorldTest = new JIWorld();
		JIObject MRBot = new JIObject();
		
		System.out.println(theWorldTest);
		
		theWorldTest.onStep();
		System.out.println(theWorldTest);
		
		theWorldTest.onStep();
		System.out.println(theWorldTest);
	}
}