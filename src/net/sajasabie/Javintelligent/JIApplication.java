package net.sajasabie.Javintelligent;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JIApplication {
	
	public static JIRenderer gRenderer;
	public static JIUpdater gUpdater;
	
	public static void initialize() {
		gRenderer = new JIRenderer();
		gUpdater = new JIUpdater();
	}
	
	public static void updateAll(long millisSinceLastUpdate) {
		gRenderer.onStep();
	}
	
	public static void main(String[] args) {
		initialize();
		JFrame frame = new JFrame("Javintelligent");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JIApplication.gUpdater.destroy();
				System.exit(0);
			}
		});
		frame.setBackground(Color.WHITE);
		gRenderer.setBackground(Color.WHITE);
		frame.setLocation(0, 0);
		frame.setSize(600,600);
		frame.setContentPane(gRenderer);
		frame.setVisible(true);
	}
	
}
