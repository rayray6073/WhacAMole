import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class WhackG {

	//size of frame
		private static final int GWIDTH = 550;
		private static final int GHEIGHT = 770;
		// creating frame
		private JFrame frame;
		//creating a mole panel 
		private MolePane molePanel;
		//creating a jpanel
		private JPanel primary;
		//creating the buttons
		private JButton startB;
		private JButton stopB;
		private JButton fastB;
		private JButton slowB;
		//creating JLabel to show the score 
		public JLabel scoreB;
		
	public WhackG() {
		//initialize all the variables, frames and buttons
				this.frame = new JFrame("WhackGUI3");
				this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.primary = new JPanel();
				primary.setPreferredSize(new Dimension(GWIDTH, GHEIGHT));
				
				this.molePanel = new MolePane();
				scoreB = new JLabel(molePanel.returnScore(),JLabel.CENTER);

				
				this.startB = new JButton("Start");
				this.stopB = new JButton("Stop");
				this.fastB = new JButton("Faster");
				this.slowB = new JButton("Slower");
				
				
				MoleButtonListener bListener = new MoleButtonListener();
				startB.addActionListener(bListener);
				stopB.addActionListener(bListener);
				fastB.addActionListener(bListener);
				slowB.addActionListener(bListener);
			
				primary.add(molePanel);
				primary.add(startB);
				primary.add(stopB);
				primary.add(fastB);
				primary.add(slowB);
				primary.add(scoreB);
				
				startB.setEnabled(false);
				stopB.setEnabled(true);
				fastB.setEnabled(true);
				slowB.setEnabled(true);
				
				this.frame.getContentPane().add(this.primary);
				this.frame.pack();
				this.frame.setVisible(true);
				}
	private class MoleButtonListener implements ActionListener{
		/*
		 * public void actionPerformed(ActionEvent e){
		 * Parameters: ActionEvent 
		 * Preconditions:none
		 * 	Returns/postcondition: determines which buttons on usable after a certain action 
		 */	 
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == startB){
				molePanel.startMole();
				startB.setEnabled(false);
				stopB.setEnabled(true);
				fastB.setEnabled(true);
				slowB.setEnabled(true);
			}else if (e.getSource() == stopB){
				molePanel.stopMole();
				startB.setEnabled(true);
				stopB.setEnabled(false);
				fastB.setEnabled(false);
				slowB.setEnabled(false);
			}
			else if(e.getSource() == fastB){
				molePanel.fasterMole();
				fastB.setEnabled(false);
				slowB.setEnabled(true);
				startB.setEnabled(false);
				stopB.setEnabled(true);
			
			}else{
				molePanel.slowerMole();
				slowB.setEnabled(false);
				fastB.setEnabled(true);
				startB.setEnabled(false);
				stopB.setEnabled(true);
				
			}
			
		
	}
		
	}
	
	
	public static void main(String[] args) {
		WhackG w = new WhackG();
	}

}



