

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MolePane extends JPanel  {
	//panel height and width
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	//the standard delay time
	private static final int DELAY = 1000;
	//timer
	private Timer timer;
	
	//the string used to convert the int scoreNum to a String used for the JLabel
	String r;

	//score number
	private int scoreNum =0;
	//the score tracker
	public JLabel scoreB;
	
	private Mol mole;
	public MolePane() {
		this.addMouseListener(new MousePanelListener());
		this.r = "" + scoreNum; //
		this.mole = new Mol();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.BLUE);	
		
		timer = new Timer(DELAY, new MoleTimerListener());
		timer.start();
		
		}
	
	/*
	 * public void paintComponenet(Graphics g){
	 * Parameters: Graphics g
	 * Preconditions:none
	 * 	Returns/postcondition: overrides the paintComponent in the super class
	 * allowing you to draw a mole/square
	 */	 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		mole.draw(g);
	}
	/*
	 * public void startMole(){
	 * Parameters: none
	 * Preconditions:timer is not running
	 * 	Returns/postcondition: starts timer 
	 */	 
	public void startMole(){
		if(!timer.isRunning()){
			timer.start();
		}
	}
	/*
	 * public void stopMole(){
	 * Parameters: none
	 * Preconditions:timer is running
	 * 	Returns/postcondition: stops timer
	 */	 
	public void stopMole(){
		if(timer.isRunning()){
			timer.stop();
		}
	}
	/*
	 * public void fasterMole(){
	 * Parameters: none
	 * Preconditions:none
	 * 	Returns/postcondition: it sets the delay time to 500
	 */	 
	public void fasterMole(){
		timer.setDelay(500);
		}
	/*
	 * public void slowerMole(){
	 * Parameters: none
	 * Preconditions:none
	 * 	Returns/postcondition: it sets the delay time to 1500
	 */	 
	public void slowerMole(){
		timer.setDelay(1500);
	}
	
	
	public class MoleTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			mole.move();
			repaint();
		}
	}
	
	 public void score(){
		 scoreNum = scoreNum+10;
		 
		}
	 /*
	  	 * public String returnScore(){
		 * Parameters: none
		 * Preconditions:none
		 * 	Returns/postcondition: returns a String the score number 
		 */	 
	 	public String returnScore(){
	 		r = "Score"+ scoreNum;
	 		return r;
	 	}

		 public class MousePanelListener extends MouseAdapter{
		/*
		 * public void mouseClicked(MouseEvent e)
		 * Parameters: MouseEvent e
		 * Preconditions:
		 * 		no preconditions   
		 * 	Returns/postcondition:
		 * 		calls score which adds 10 points to the score  		
		 */
		
			public void mouseClicked(MouseEvent e){
				int mouseX = e.getX();
				int mouseY = e.getY();
				int moleEndX = mouseX+500;
				int moleEndY = mouseY+500;
				if(mouseX >= getX() && mouseX <= moleEndX){
					if(mouseY >= getY() && mouseY <= moleEndY){
						if(mouseX == mole.getX() && mouseY == mole.getY()){
							System.out.print("clicked");
						
							//call the score keeping method 
							score();
							returnScore();
						
						}
					}
					
				}
				
				
		
			}
		}
		
	

}
