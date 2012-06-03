package net.sajasabie.Javintelligent;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JIApplication {
	
	public static JIRenderer gRenderer;
	
	public static void main(String[] args) {
		gRenderer = new JIRenderer();
		JFrame frame = new JFrame("Javintelligent");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setBackground(Color.WHITE);
		gRenderer.setBackground(Color.WHITE);
		frame.setLocation(0, 0);
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setContentPane(gRenderer);
		
	}
	
}
