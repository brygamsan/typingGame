/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/

package View; // Within 'View' Package

import java.awt.*; // Imports All Awt Classes
import javax.swing.*; // Imports Swing Classes
import javax.swing.border.EmptyBorder; // Imports EmptyBorder Class

/**
 * The CenterPanel Class is designed to set up and 
 * displays the Center of the GUI in an organized Panel.
 * This Class handles everything displayed within the Center Panel.
 * Extends [JPanel]
 * @author alexplaton, etc.
 */
public class CenterPanel extends JPanel { // Class Center Panel | Extends JPanel
	
	// Class Variables | Private 
	
	private JLabel lbl, lbl2; // New Private JLabels 'lbl', 'lbl2'
    private JButton[] buttonList = new JButton[33]; // New Private JButton Array 'buttonList'
	
	// Class Fonts
	private Font smlFont = new Font("Verdana", Font.BOLD, 24); // New Font 'smlFont'
	private Font lrgFont = new Font("Verdana", Font.BOLD, 28); // New Font 'lrgFont'
	
	/*
	 * This is the CenterPanel's Constructor.
	 * This Constructor is designed to setup everything within
	 * Center Panel when the game starts up. The constructor specifically handles
	 * the "Main Menu".
	 */
	public CenterPanel(JButton bttn1, JButton bttn2, JButton bttn3) {
		
		// Setting up CenterPanel | Panel
		super(); // Call Super Method | JPanel
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // Set Layout to BoxLayout
		setBackground(new Color(177, 138, 201)); // Set Background Color | Color [177, 138, 201], Purple
		
		// Add & Set up Objects to CenterPanel
		bttn1.setMaximumSize(new Dimension(150,450)); // Set 'bttn1' Max Size
		bttn1.setAlignmentX(Component.CENTER_ALIGNMENT); // Set 'bttn1' Alignment to Center
		bttn2.setMaximumSize(new Dimension(150,450)); // Set 'bttn2' Max Size
		bttn2.setAlignmentX(Component.CENTER_ALIGNMENT); // Set 'bttn2' Alignment to Center
		bttn3.setMaximumSize(new Dimension(150,450)); // Set 'bttn3' Max Size
		bttn3.setAlignmentX(Component.CENTER_ALIGNMENT); // Set 'bttn3' Alignment to Center
		add(bttn1); // Add 'bttn1' to 'CenterPanel'
		add(bttn2);	// Add 'bttn2' to 'CenterPanel'
		add(bttn3); // Add 'bttn3' to 'CenterPanel'
		
	}
	
	/*
	 * The 'makeCenterPNLSettings' method is designed to
	 * setup the Center Panel to properly display
	 * the game inside of the GUI. This method only
	 * handles the Center Panel.
	 */
	public void makeCenterPNLGame() {
		
		clearPanel(); // Call 'clearPanel'
		
	}
	
	/*
	 * The 'makeCenterPNLSettings' method is designed to
	 * setup the Center Panel to properly display
	 * the settings inside of the GUI. This method only
	 * handles the Center Panel.
	 */
	public void makeCenterPNLSettings(JCheckBox cb1, JCheckBox cb2, JCheckBox cb3) {
		
		// Inital Center Panel Setup | Settings Center Panel
		clearPanel(); // Calls 'clearPanel' Method
		setBorder(new EmptyBorder(25,25,25,25)); // Creates New Empty Border | Parameters [25, 25, 25, 25]
		
		// Setup CheckBoxes & Labels 
		cb1.setFont(smlFont); // Sets 'cb1' font to 'smlFont'
		cb1.setAlignmentX(CENTER_ALIGNMENT); // Set 'cb1' Alignment to Center
		cb1.setBackground(new Color(177,138,201)); // Set 'cb1' Background to Color | Color: [177, 138, 201], Purple
		cb1.setSelected(true); // Set 'cb1' to be selected on launch
		add(cb1); // Add 'cb1' to 'CenterPanel'
		
		cb2.setFont(smlFont); // Sets 'cb2' font to 'smlFont'
		cb2.setAlignmentX(CENTER_ALIGNMENT); // Set 'cb1' Alignment to Center
		cb2.setBackground(new Color(177,138,201)); // Set 'cb2' Background to Color | Color: [177, 138, 201], Purple
		cb2.setSelected(true); // Set 'cb2' to be selected on launch
		add(cb2); // Add 'cb2' to 'CenterPanel'
		
		cb3.setFont(smlFont); // Sets 'cb3' font to 'smlFont'
		cb3.setAlignmentX(CENTER_ALIGNMENT); // Set 'cb1' Alignment to Center
		cb3.setBackground(new Color(177,138,201)); // Set 'cb3' Background to Color | Color: [177, 138, 201], Purple
		add(cb3); // Add 'cb3' to 'CenterPanel'
		
		lbl = new JLabel("* If none are selected score will not be saved or displayed *"); // Set 'lbl' text | Text: "* If none are selected score will not be saved or displayed *"
		lbl.setAlignmentX(CENTER_ALIGNMENT); // Set 'lbl' Alignment to Center
		add(lbl); // Add 'lbl' to 'CenterPanel'
		//
			
	}
	
	/*
	 * The 'makeCenterPNLRules' method is designed to
	 * setup the Center Panel to properly display
	 * the rules inside of the GUI. This method only
	 * handles the Center Panel.
	 */
	public void makeCenterPNLRules() {
		
		// Inital Center Panel Setup | Rules Center Panel
		clearPanel(); // Calls 'clearPanel' Method
		setBorder(new EmptyBorder(10, 10, 10, 10)); // Creates New Empty Border | Parameters [10, 10, 10, 10]
		
		// Setup Labels
		lbl = new JLabel("Welcome to Type and Go! Education and Learning"); // Set 'lbl' text | Text: "Welcom to type and Go!"
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		lbl.setFont(lrgFont); // Sets 'lbl' font to 'lrgFont'
		lbl2 = new JLabel("<html><br>This typing game is very simple to play and learn!<br>"
				+ "The Rules to Play are Listed Below.<br><br>"
				+ "Anytime you hit the backspace points will be deducted!<br>"
				+ "Anytime you misspell a word points will be deducted!<br>"
				+ "If your collective score is less than 50%, you lose!</html>", SwingConstants.CENTER); // New JLabel 'lbl2' | HTML Text
		lbl2.setAlignmentX(CENTER_ALIGNMENT); // Set 'lbl2' Alignment to Center
		lbl2.setFont(smlFont); // Set 'lbl2' Font to 'smlFont'
		//
		
		add(lbl); // Add 'lbl' to 'CenterPanel'
		add(lbl2); // Add 'lbl2' to 'CenterPanel'
			
	}
	
	/*
	 * The 'makeCenterPNLLeaderboard' method is designed to
	 * setup the Center Panel to properly display
	 * the leaderboard inside of the GUI. This method only
	 * handles the Center Panel.
	 */
	public void makeCenterPNLLeaderboard() {
			
			// Initial Center Panel Setup | Rules Center Panel
			clearPanel(); // Calls 'clearPanel' Method
			
			JPanel scorePanel = new JPanel(); //Create jPanel 'scorePanel' | a temp panel meant for avoiding layout changes to center panel
	        scorePanel.setLayout(new GridLayout(11, 3));

	        // create header buttons
	        buttonList[0] = new JButton("Name"); // New JButton in 'buttonList' at spot 0 | Text: "Name"
	        buttonList[1] = new JButton("WPM"); // New JButton in 'buttonList' at spot 1 | Text: "WPM"
	        buttonList[2] = new JButton("Backspace Count"); // New JButton in 'buttonList' at spot 2 | Text: "Accuracy"
	        
	        // create score buttons
	        for (int i = 3; i < buttonList.length; i++) {
	        	
	            buttonList[i] = new JButton("N/A"); // Add Text to Buttons
	            buttonList[i].setFont(new Font("Verdana", Font.BOLD, 12)); // Set Button Font
	            buttonList[i].setPreferredSize(new Dimension(30, 35)); // Set Button Size
	            
	        }
	        
	        //disables buttons and adds buttons
	        for (JButton button : buttonList) { // For Every JButton in 'buttonList'
	        	
	        	button.setEnabled(false); // Disable Buttons
	            scorePanel.add(button); // Add 'button' to 'scorePanel'
	            
	        }
	        
	        add(scorePanel); //add 'scorePanel' into 'CenterPanel'				
	}
	
	/*
	 * The 'clearPanel' method is designed to clear
	 * the Center Panel.
	 */
	private void clearPanel() {
		
		removeAll(); // Remove All Content
		revalidate(); // Reload JPanel
        repaint();  // Prepare JPanel
        
	}	
}