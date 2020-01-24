package jman22.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {

	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	
	public Apple(int xCoord, int yCoord, int tileSize) {
		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick() {
		
		
	}
	
	public void draw(Graphics graphic) {
		
		graphic.setColor(Color.RED);
		graphic.fillRect(xCoord * width, yCoord * height, width, height);
	
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
}
