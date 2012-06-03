package net.sajasabie.Javintelligent;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JIApplication {
	
	public static JIRenderer mRenderer;
	public static JIUpdater mUpdater;
	public static JIWorld mWorld;
	
	public static JIRenderable testRenderable;
	
	public static void initialize() {
		mRenderer = new JIRenderer();
		mUpdater = new JIUpdater();
		mWorld = new JIWorld();
	}
	
	public static void updateAll(long millisSinceLastUpdate) {
		mWorld.onStep();
		mRenderer.repaint();
		System.out.println("Millis: " + millisSinceLastUpdate);
	}
	
	public static JIRenderer getRenderer() {
		return mRenderer;
	}
	
	public static void main(String[] args) {
		JIApplication.initialize();
		JFrame frame = new JFrame("Javintelligent");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (JIApplication.mUpdater != null) JIApplication.mUpdater.destroy();
				if (JIApplication.mRenderer != null) JIApplication.mRenderer.destroy();
				System.exit(0);
			}
		});
		frame.setBackground(Color.WHITE);
		mRenderer.setBackground(Color.WHITE);
		frame.setLocation(0, 0);
		frame.setSize(600,600);
		frame.setContentPane(mRenderer);
		frame.setVisible(true);
	}
	
}
