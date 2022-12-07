/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/

package View; // Within View Package

import java.awt.*; // Import Awt Classes
import javax.swing.*; // Imports Swing Classes


/**
 * The MainGUI Class is what sets up and 
 * displays the GUI in a neatly organized window.
 * @author alexplaton, etc.
 *
 */
public class SouthPanel extends JPanel {
	
	// Class Variables | Private 
	
	/*
	 * This is SouthPanel's Constructor.
	 * This Constructor is designed to set up all of the objects used within
	 * SouthPanel. All of the buttons are passed over from the Controller class.
	 */
	public SouthPanel() {
		
		// Setting up SouthPanel | Panel
		super(); // Call Super Class | JPanel
		
	}
	
	public void makeSouthPNLGame() {
		
		clearPanel(); // Call 'clearPanel'
		
	}
	
	/*
	 * The 'makeSouthPNlSettings' method is designed to setup the 
	 * SouthPanel with 2 JButtons when the settings menu is opened.
	 */
	public void makeSouthPNLSettings(JButton setBttn1, JButton setBttn2) {
		
		clearPanel(); // Call 'clearPanel' method
		setBackground(new Color(201, 189, 138)); // Set Background Color | Color [201, 189, 138], Gold
		
		// Add to SouthPanel
		add(setBttn1); // Add 'setBttn1' to SouthPanel
		add(setBttn2); // Add 'setBttn2' to SouthPanel
		
	}
	
	public void makeSouthPNLRules(JButton setBttn2) {
		
		clearPanel();
		setBackground(new Color(201, 189, 138)); // Set Background Color | Color [201, 189, 138], Gold
		
		// Add to South Panel
		add(setBttn2); // Add 'setBttn2' to SouthPanel
		
	}
	
	/*
	 * The 'makeSouthPNLLeaderboard' method is designed to setup the 
	 * SouthPanel with 3 JButtons when the Leaderboard menu is opened.
	 */
	public void makeSouthPNLLeaderboard(JButton lbBttn1) {
		
		clearPanel(); // Call 'clearPanel' method
		setBackground(new Color(201, 189, 138)); // Set Background Color | Color [201, 189, 138], Gold
		
		// Add to South Panel
		add(lbBttn1); // Add 'setBttn2' to SouthPanel
		
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