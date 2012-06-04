package net.sajasabie.Javintelligent;

public class JIGlobals {
	public final double WORLD_WIDTH = 1.0;
	public final double WORLD_HEIGHT = 1.0;
	public final double MAX_SPEED = 0.005;
	public final int VIEW_WIDTH = 600;
	public final int VIEW_HEIGHT = 600;
	public final double SIGHT_RANGE = 0.05;
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2-x1), 2.0d) + Math.pow((y2-y1), 2.0d));
	}
}