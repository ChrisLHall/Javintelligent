package net.sajasabie.Javintelligent;



public class JIWorldTest {
	public static void main(String[] argv) {
		JIWorld theWorldTest = new JIWorld();
		System.out.println(theWorldTest);
		
		System.out.println(theWorldTest.move(0.02f,0.02f));
		System.out.println(theWorldTest);
		
		System.out.println(theWorldTest.move(-0.02f,-0.02f));
		System.out.println(theWorldTest);
	}
}