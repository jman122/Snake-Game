package jman22;

import javax.swing.JFrame;
import java.awt.GridLayout;
import jman22.graphics.Screen;

public class Frame extends JFrame{

	public Frame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		setTitle("Snake");
		setResizable(false);
		
		init();
	}
	
	public void init() {
		
		setLayout(new GridLayout(1, 1, 0, 0));           
		
		Screen newScreen = new Screen();
		add(newScreen);
		
		pack();                                          
		
		setLocationRelativeTo(null);                     
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Frame();
	}
}
