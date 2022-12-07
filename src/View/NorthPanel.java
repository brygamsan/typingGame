/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/

package View; // Within View Package

import java.awt.*; // Imports Awt Classes
import javax.swing.*; // Imports Swing Classes
import javax.swing.border.Border; // Imports Border Class
import Controller.GameTimer; // Import GameTimer Class

/**
 * The MainGUI Class is what sets up and 
 * displays the GUI in a neatly organized window.
 * @author alexplaton, etc.
 *
 */
public class NorthPanel extends JPanel { // Class NorthPanel | Extends JPanel
	
	// Class Variables | Private 
	private JLabel txtArea, label; // New JLabel 'textArea', 'label'
	private Border menuBorder; // New Border 'menuBorder'
	private Font font; // New Font 'font'
	
	/*
	 * This is NorthPanel's Constructor.
	 * This Constructor is designed to set up all of the objects
	 * that are held withn the NorthPanel.
	 */
	public NorthPanel() {
		
		// Setting up MainPanel | Panel
		super(); // Calls Super Method | JPanel
		menuBorder = BorderFactory.createLineBorder(Color.ORANGE); // Set 'menuBorder' to a new Orange Line Border
		txtArea = new JLabel(); // Set 'txtArea' to new JLabel
		font = new Font("Monospaced Italic", Font.BOLD, 28); // Set 'font' to Customized Font
		txtArea.setFont(font); // Calls 'setFont' from 'txtArea'
		setBorder(menuBorder); // Set 'menuBorder' as Border
		setBackground(new Color(201, 189, 138)); // Set Background Color to new Color | Color [201, 189, 138], Gold Color
		
		
		// Add & Set up Objects to NorthPanel
		txtArea.setText("Type and Go | For Education and Learning!"); // Set 'txtArea' text | Text: "Type and Go | For Education and Learning!"
		label = new JLabel(); // Set 'label' as New JLabel
		add(txtArea); // Add 'txtArea' to NorthPanel
		
	}
	
	public void makeNorthPNLGame(GameTimer timer, JLabel timerLbl) {
		
		// Setting up 'NorthPanel' Settings Menu | JPanel
		clearPanel(); // Call 'clearPanel' method
		timer.startTimer();
		timerLbl.setFont(font);
		add(timerLbl);
		
		
	}
	
	/*
	 * The 'makeNorthPNLSettings' method is designed to setup the North Panel
	 * within the settings menu so that all of the text and buttons are
	 * displayed in a neat organized fashion within the North Panel.
	 */
	public void makeNorthPNLSettings() {
		
		// Setting up 'NorthPanel' Settings Menu | JPanel
		clearPanel(); // Call 'clearPanel' method
		label.setText("Settings Menu"); // Set 'label' text | Text: "Settings Menu"
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // Set Layout to new BoxLayout
		setBackground(new Color(177, 138, 201)); //Set Background Color | Color [177,138, 201], Purple
		label.setAlignmentX(CENTER_ALIGNMENT); // Set 'label' to CenterAlignment on X 
		label.setFont(font); // Set 'label' Font
		
		// Add to NorthPanel
		add(label); // Add 'label' to NorthPanel
				
	}
	
	/*
	 * The 'makeNorthPNLRules' method is designed to setup the North Panel
	 * within the rules menu so that all of the text are
	 * displayed in a neat organized fashion within the North Panel.
	 */
	public void makeNorthPNLRules() {
		
		// Setting up 'NorthPanel' Rules Menu | JPanel
		clearPanel(); // Call 'clearPanel' method
		label.setText("Rules Menu"); // Set 'label' text | Text: "Rules Menu"
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // Set Layout to new BoxLayout
		setBackground(new Color(177,138,201)); //Set Background Color | Color [177,138, 201], Purple
		label.setAlignmentX(CENTER_ALIGNMENT); // Set 'label' to CenterAlignment on X 
		label.setFont(font); // Set 'label' Font
		
		// Add to NorthPanel
		add(label); // Add 'label' to NorthPanel
		
	}
	
	/*
	 * The 'makeNorthPNLLeaderboard' method is designed to setup the North Panel
	 * within the leaderboard menu so that all of the text are
	 * displayed in a neat organized fashion within the North Panel.
	 */
	public void makeNorthPNLLeaderboard() {
		
		// Setting up 'NorthPanel' Leaderboard Menu | JPanel
		clearPanel(); // Call 'clearPanel' method
		label.setText("Leaderboard Menu"); // Set 'label' text | Text: "Rules Menu"
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // Set Layout to new BoxLayout
		setBackground(new Color(177,138,201)); //Set Background Color | Color [177,138, 201], Purple
		label.setAlignmentX(CENTER_ALIGNMENT); // Set 'label' to CenterAlignment on X 
		label.setFont(font); // Set 'label' Font
		
		// Add to NorthPanel
		add(label); // Add 'label' to NorthPanel
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