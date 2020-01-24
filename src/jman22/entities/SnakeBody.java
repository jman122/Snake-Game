package jman22.entities;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeBody {

	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	
	public SnakeBody(int xCoord, int yCoord, int tileSize) {
		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick() {
		
		
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

	public void draw(Graphics graphic) {
		
		graphic.setColor(Color.BLACK);
		graphic.fillRect(xCoord * width, yCoord * height, width, height);
		
		graphic.setColor(Color.GREEN);
		graphic.fillRect(xCoord * width + 2, yCoord * width + 2, width - 4, height - 4);
	}
}
