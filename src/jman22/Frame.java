package jman22;

import javax.swing.JFrame;
import java.awt.GridLayout;
import jman22.graphics.Screen;

public class Frame extends JFrame{

	public Frame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // X button to close window
		setTitle("Snake");
		setResizable(false);
		
		init();
	}
	
	public void init() {
		
		setLayout(new GridLayout(1, 1, 0, 0));           // Centers the window
		
		Screen newScreen = new Screen();
		add(newScreen);
		
		pack();                                          //Makes the window to the preferred size
		
		setLocationRelativeTo(null);                     // Centers the frame on the middle of the screen
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Frame();
	}
}
