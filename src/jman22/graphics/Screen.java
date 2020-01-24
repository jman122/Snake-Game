package jman22.graphics;

import javax.swing.JPanel;

import jman22.entities.Apple;
import jman22.entities.SnakeBody;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel implements Runnable{

	public static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	private Thread thread;
	private boolean running = false;
	
	private Random spawn;
	
	private SnakeBody body;
	private ArrayList<SnakeBody> snake;
	
	private Apple apple;
	private ArrayList<Apple> apples;
	 
	private int xCoord = 10;                                   
	private int yCoord = 10;
	private int size = 5;
	private int ticks = 0;
	
	private boolean right = false, left = false, up = false, down = true;
	
	private Key key;
	
	public Screen() {
		
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		snake = new ArrayList<SnakeBody>();
		apples = new ArrayList<Apple>();
		
		spawn = new Random();
		
		start();
	}
	
	public void start() {
		
		running = true;
		thread = new Thread(this, "Game Loop");               
		thread.start();                                        
	}
	
	public void stop() {
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		while (running) {
			tick();
			repaint();
		}
	}
	
	public void tick() {
		
		if (snake.size() == 0) {
			body = new SnakeBody(xCoord, yCoord, 10);
			snake.add(body);
		}
		
		if (apples.size() == 0) {
			int xCoord = spawn.nextInt(79);
			int yCoord = spawn.nextInt(79);
			
			apple = new Apple(xCoord, yCoord, 10);
			apples.add(apple);
		}
		
		for (int i = 0; i < apples.size(); i++) {
			if (xCoord == apples.get(i).getxCoord() && yCoord == apples.get(i).getyCoord()) {
				size++;
				apples.remove(i);
				i--;
			}
		}
		
		for (int i = 0; i < snake.size(); i++) {
			if (xCoord == snake.get(i).getxCoord() && yCoord == snake.get(i).getyCoord()) {
				if (i != snake.size() - 1) {
					stop();
				}
			}
		}
		
		if (xCoord < 0) {
			xCoord += 81;
		}
		else if (xCoord > 79) {
			xCoord -= 81;
		}
		if (yCoord < 0) {
			yCoord += 81;
		}
		else if (yCoord > 79) {
			yCoord -= 81;
		}
		
		ticks++;
		
		if (ticks > 500000) {
			if (right) {
				xCoord++;
			}
			if (left) {
				xCoord--;
			}
			if (up) {
				yCoord--;
			}
			if (down) {
				yCoord++;
			}
			
			ticks = 0;
			
			body = new SnakeBody(xCoord, yCoord, 10);
			snake.add(body);
			
			if (snake.size() > size) {
				snake.remove(0);
			}
		}
	}
	
	public void paint(Graphics graphic) {
		
		graphic.clearRect(0, 0, WIDTH, HEIGHT);                   // clears the screen
		graphic.setColor(Color.BLUE);
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		
		graphic.setColor(Color.BLACK);
		
		for (int i = 0; i < (WIDTH / 2); i++) {                   // 10x10 tile size 
			graphic.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		
		for (int i = 0; i < (HEIGHT / 2); i++) {
			graphic.drawLine(0, i * 10, WIDTH, i * 10);
		}
		
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(graphic);
		}
		
		for (int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(graphic);
		}
	}
	
	private class Key implements KeyListener {

		public void keyPressed(KeyEvent e) {
		
			int key = e.getKeyCode();
			
	        if(key == KeyEvent.VK_RIGHT && !left) {
	            up = false;
	            down = false;
	            right = true;
	        }
	        
	        if(key == KeyEvent.VK_LEFT && !right) {
	            up = false;
	            down = false;
	            left = true;
	        }
	        
	        if(key == KeyEvent.VK_UP && !down) {
	            left = false;
	            right = false;
	            up = true;
	        }
	        
	        if(key == KeyEvent.VK_DOWN && !up) {
	            left = false;
	            right = false;
	            down = true;
	        }
		}

		public void keyReleased(KeyEvent e) {               // Not needed
		
		}
		
		public void keyTyped(KeyEvent e) {                  // Not needed
			
		}
	}
}
