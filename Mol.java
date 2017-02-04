

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Mol{
	//Mole height 
	private static final int HEIGHT = 50;
	//mole width
	private static final int WIDTH = 50;
	//mole color
	private static final Color SQUARE_COLOR = Color.white;
	
	//mole x and y position
	private int x,y;

	private Random rand;
	
	public Mol() {
		this.x = 0;
		this.y = 0;
		
		rand = new Random();
		}
	/*
	 * public void draw(Graphic g){
	 * Parameters: Graphic 
	 * Preconditions:none
	 * 	Returns/postcondition: draws the mole
	 */	 
	public void draw(Graphics g){
		g.setColor(this.SQUARE_COLOR);
		g.fillRect(x,y,HEIGHT,WIDTH);
	}
	/*
	 * public void move(){
	 * Parameters: none 
	 * Preconditions:none
	 * 	Returns/postcondition:randomly generates a new location for the mole to move to 
	 */	 
	public void move(){
		this.x = rand.nextInt(MolePane.WIDTH-WIDTH);
		this.y = rand.nextInt(MolePane.HEIGHT-HEIGHT);
	}
	/*
	 * public int getX(){
	 * Parameters: none 
	 * Preconditions:none
	 * 	Returns/postcondition: returns mole x value
	 */	 
	public int getX(){
		return x;
	}
	/*
	 * public int getY(){
	 * Parameters: none 
	 * Preconditions:none
	 * 	Returns/postcondition:returns the moles y value ;
	 */	 
	public int getY(){
		return y;
	}
	
}
