/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/

package Controller; // Within Package Controller

import java.awt.event.ActionEvent; // Import ActionEvent Class
import java.awt.event.ActionListener; // Import ActionListener Class
import java.io.File;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*; // Imports Swing Classes
import View.MainFrame; // Import 'View' Package
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The GUIController Class is what sets up and 
 * displays the GUI in a neatly organized window.
 * This Class is a controller, allowing user interaction.
 * IMPLEMENTS: ActionListener
 * @author alexplaton, etc.
 */
public class GUIController implements ActionListener{ // Class GUIController | Implements ActionListener 
	
	// Class Variables | Private
	private MainFrame frame; // New MainFrame 'frame'
	private JButton bttn1, bttn2, bttn3, setBttn1, setBttn2; // New JButtons 'bttn1', 'bttn2', 'bttn3', 'setBttn1', 'setBttn2'
	private JCheckBox cb1, cb2, cb3; // New CheckBoxes 'cb1', 'cb2', 'cb3'
	private JMenuBar menuBar; // New JMenuBar 'menuBar'
	private JMenu menu1, menu2, menu3; // New JMenus 'menu1', 'menu2', 'menu3'
	private JMenuItem subMen1,subMen2,subMen3, subMen4, subMen5, subMen6; // New JMenuItems 'subMen1', 'subMen2', 'subMen3', 'subMen4', 'subMen5', 'subMen6'
	private GameTimer gameTimer; // New GameTimer 'timer'
	private JLabel timerLbl; // New JLabel 'timerLbl'
	private ImageIcon gameIcon; // New ImageIcon 'gameIcon'
	private JTextField wordBox;
	// Class Variables Final
	private final int SELECTION_SOUND = 0; // New Final Int 'SELECTION_SOUND' set to 0
	
	/*
	 * This is the Class Constructor.
	 * This Constructor is designed to setup the objects and
	 * variables within the GUI, it implements the ActionListener
	 * Class to allow user interactions with the buttons and menu options.
	 */
	public GUIController(){
		
		// Setting up the GUI & Objects for Main Menu + Play | Frame
		bttn1 = new JButton("Play"); // New JButton 'bttn1' | Text: "Play"
		bttn2 = new JButton("Settings"); // New JButton 'bttn2' | Text: "Settings"
		bttn3 = new JButton("Exit"); // New JButton 'bttn3' | Text: "Exit"
		timerLbl = new JLabel(); // Sets 'timerLbl' as new JLabel
		gameTimer = new GameTimer(timerLbl, 60); // Sets 'timer' as new GameTimer
		frame = new MainFrame(bttn1, bttn2, bttn3); // Sets 'frame' as new MainFrame object | Parameters [bttn1, bttn2, bttn3]	
		setMenu();
		
		
		
		// Setting up the GUI & Object Settings Menu | Frame
		setBttn1 = new JButton("Add Custom Words"); // New JButton 'setBttn1' | Text: "Add Custom Words"
		setBttn2 = new JButton("Main Menu"); // New JButton 'setBttn2' | Text: "Main Menu"
		cb1 = new JCheckBox("Words Per Minute"); // New CheckBox 'cb1' | Text: "Words Per Minute"
		cb2 = new JCheckBox("Time Counter"); // New CheckBox 'cb2' | Text: "Time Counter"
		cb3 = new JCheckBox("Missed Word Count"); // New CheckBox 'cb3' | Text: "Missed Word Count"
		gameIcon = new ImageIcon("Icon.png"); // New ImageIcon 'gameIcon'
		
		
		// Add Action Listeners
		bttn1.addActionListener(this); // Add ActionListener to 'bttn1'
		bttn2.addActionListener(this); // Add ActionListener to 'bttn2'
		bttn3.addActionListener(this); // Add ActionListener to 'bttn3'
		setBttn1.addActionListener(this); // Add ActionListener to 'setBttn1'
		setBttn2.addActionListener(this); // Add ActionListener to 'setBttn2'
		cb1.addActionListener(this); // Add ActionListener to 'cb1'
		cb2.addActionListener(this); // Add ActionListener to 'cb2'
		cb3.addActionListener(this); // Add ActionListener to 'cb3'
		subMen1.addActionListener(this); // Add ActionListener to 'subMen1'
		subMen2.addActionListener(this); // Add ActionListener to 'subMen2'
		subMen3.addActionListener(this); // Add ActionListener to 'subMen3'
		subMen4.addActionListener(this); // Add ActionListener to 'subMen4'
		subMen5.addActionListener(this); // Add ActionListener to 'subMen5'
		subMen6.addActionListener(this); // Add ActionListener to 'subMen6'

		
		// Set Visibility
		frame.setVisible(true);	// Set Visibility to True
	}
	
	/*
	 * The 'setMenu' method is designed to set up 
	 * the JMenu within the frame, it displays drop 
	 * down menus with options inside for the user to 
	 * interact with.
	 */
	private void setMenu() {
		
		// Set up JMenuBar
		menuBar = new JMenuBar(); // New JMenuBar 'menuBar'
		
		// Set up JMenu | Set up JMenuItems
		menu1 = new JMenu("File"); // Add JMenu 'menu1' | Text: "Files"
		menu2 = new JMenu("Rules");	 // Add JMenu 'menu2' | Text: "Rules"
		menu3 = new JMenu("Leaderboard"); // Add JMenu 'menu3' | Text: "Leaderboard"
		
		
		// Set up Submenus
		subMen1 = new JMenuItem("About Developers"); // Adds JMenuItem 'subMen2' | Text: "About Developers"
		subMen2 = new JMenuItem("Add Custom Words"); // Adds JMenuItem 'subMen2' | Text: "Add Custom Words"
		subMen3 = new JMenuItem("Version"); // Adds JMenuItem "subMen3" to JMenu | Current Version v1.3
		subMen4 = new JMenuItem("Exit"); // Adds JMenuItem 'subMen4' | Text: "Exit"
		subMen5 = new JMenuItem("See Rules"); // Adds JMenuItem 'subMen5' | Text: "See Rules"
		subMen6 = new JMenuItem("See Leaderboard"); // Adds JMenuItem 'subMen6' | Text: "See Leaderboard"
		
		
		// Combine Menus
		menuBar.add(menu1); // Add 'menu1' to 'menuBar'
		menuBar.add(menu2); // Add 'menu2' to 'menuBar'
		menuBar.add(menu3); // Add 'menu3' to 'menuBar'
		menu1.add(subMen1); // Add 'subMen1' to 'menu1'
		menu1.add(subMen2); // Add 'subMen2' to 'menu1'
		menu1.add(subMen3); // Add 'subMen3' to 'menu1'
		menu1.add(subMen4); // Add 'subMen4' to 'menu1'
		menu2.add(subMen5); // Add 'subMen5' to 'menu2'
		menu3.add(subMen6); // Add 'subMen6' to 'menu3'
		
		
		
		// Add Menu to Frame
		frame.setJMenuBar(menuBar); // Set 'frame' JMenuBar to 'menuBar'
		
	}
	
	/*
	 * The 'loadMainMenu' method simply 
	 * loads the Games Main Menu
	 */
	private void loadMainMenu() {
		
		frame.clearFrame(); // Call 'clearFrame' from 'frame'
		frame.makeMainMenu(bttn1, bttn2, bttn3); // Call 'makeMainMenu' from frame | Parameters [bttn1, bttn2, bttn3]
		menu2.setEnabled(true); // Enable 'menu2'
		menu3.setEnabled(true); // Enable 'menu3'
		gameTimer.stopTimer(); // Stop Timer
		frame.setVisible(true); // Set 'frame' Visibility to True
		
	}
	
	/*
	 * The 'playSound' method is designed to play specific sounds
	 * within the game. The sounds that are played correlate to 
	 * the parameter (Integer) send over by the progam.
	 * [0: Logo Sound, 1: In Game Music]
	 */
	private void playSound(int selectedSound) {
		
		File menuSelect = new File("Menu Select.wav"); // New File 'logoSound' set to 'Logo Noise.wav'
		
		if (selectedSound == 0) { // if 'selectedSound' is equal to 0
			try { // Try to
				
				Clip clip = AudioSystem.getClip(); // New Clip 'clip'
				clip.open(AudioSystem.getAudioInputStream(menuSelect)); // Open 'logoSound'
				clip.start(); // Start 'clip'
				
			}
			catch(Exception e) { // If an Exception is Caught
				System.out.println(e); // Print the Exception
			}
		}
	}  
	
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void wordGenerator(JTextField wordBox) throws FileNotFoundException, IOException {
		List<String>words = new ArrayList<>();
		/**
		 * 
		 */
		
	 try (BufferedReader read = new BufferedReader(new FileReader("word.txt"))) {
		String line = read.readLine();
		
		while (line!=null){
		words.add(line);
		}
	}
	Random rand= new Random(words.size());
	final String word = words.get(rand.nextInt());

	for(int i = 0; i < ((File) words).length(); i++){
		 wordBox.setText(words.get(i));
	}
	}
	

	
	/*
	 * The 'actionPerformed' method was designed to be called
	 * when the user interacts with the GUI. This method will
	 * run code if, buttons, checkboxes or even text fields are
	 * interacted with. [METHOD OVERRIDE]
	 */
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(bttn1)) { // If 'bttn1' is Clicked
			
			frame.clearFrame(); // Call 'clearFrame' from 'frame'
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			frame.makeGameMenu(gameTimer, timerLbl); // Call 'makeGameMenu' from 'frame'
			menu2.setEnabled(false); // Disable 'menu2'
			menu3.setEnabled(false); // Disable 'menu2'
			frame.setVisible(true); // Set 'frame' Visibility to True
			
		}
				
		if (e.getSource().equals(bttn2)) { // If 'bttn2' is Clicked
			
			frame.clearFrame(); // Clear GUI's JFrame 'frame'
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			frame.makeSettingsMenu(setBttn1, setBttn2, cb1, cb2, cb3); // Call 'makeSettingsMenu' from 'frame' | Parameters {setBttn1, setBttn2, cb1, cb2, cb3}
			frame.setVisible(true); // Set 'frame' Visibility to True
			
		}
		
		if (e.getSource().equals(bttn3)) {
			
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want\nto exit the game?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE ,gameIcon) == JOptionPane.YES_OPTION) // If User Clicks Yes
			    System.exit(0);	// Close Application
			
		}
		
		if (e.getSource().equals(setBttn1)) {
			
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			// ADD CUSTOM WORD CODE HERE
			
    
 
			
		
		
		if (e.getSource().equals(setBttn2)) { // If 'setBttn2' is Clicked
			
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			loadMainMenu(); // Call 'loadMainMenu'
			
		}
		
		if (e.getSource().equals(cb1)) {
			
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			
		}
		
		if (e.getSource().equals(cb2)) {
			
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			
		}

		if (e.getSource().equals(cb3)) {
	
			playSound(SELECTION_SOUND); // Call 'playSound' | Parameter [SELECTION_SOUND]
			
		}
				
		if (e.getSource().equals(subMen1)) { // If 'subMen1' is clicked
			
			if (!frame.isInGame()) { // If 'isInGame' from 'frame' is False
				
				JOptionPane.showMessageDialog(null,"\nType and Go | Education and Learning\n"
						+ "\nAlexander Platon: Lead Programmer & GUI Design"
						+ "\nBryan Sanchez: Project Managment & Error Control"
						+ "\nPhillip Nguyen: Project Layout Manager & Organizer\n"
						+ "\nBrought to you by The Four Horsmen Coding INC.\n", "About the Developers!\n", JOptionPane.INFORMATION_MESSAGE, gameIcon); // Open new JOptionPane | Displays Dev. Information
				
			}
			else {	
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the game?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE ,gameIcon) == JOptionPane.YES_OPTION) { // If User Clicks Yes
					
					loadMainMenu(); // Call 'loadMainMenu'
					JOptionPane.showMessageDialog(null,"\nType and Go | Education and Learning\n"
							+ "\nAlexander Platon: Lead Programmer & GUI Design"
							+ "\nBryan Sanchez: Project Managment & Error Control"
							+ "\nPhillip Nguyen: Project Layout Manager & Organizer\n"
							+ "\nBrought to you by The Four Horsmen Coding INC.\n", "About the Developers!\n", JOptionPane.INFORMATION_MESSAGE, gameIcon); // Open new JOptionPane | Displays Dev. Information
							
				}
			}		
		}
		
		if (e.getSource().equals(subMen2)) { // If 'subMen2' is Clicked
			
			if (!frame.isInGame()) {
				// Add Code Here | ADD CUSTOM WORDS METHOD HERE!!!
				
			}
			
			else {	
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the game?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE ,gameIcon) == JOptionPane.YES_OPTION) { // If User Clicks Yes
					
					gameTimer.stopTimer(); // Stop Timer
					loadMainMenu(); // Call 'loadMainMenu'
					
				}
			}	
		}		
		
		if (e.getSource().equals(subMen3)) // If 'subMen3' is Clicked
			
			if (!frame.isInGame()) 
				JOptionPane.showMessageDialog(null, "Type and Go Version\nCurrent Game Version: 1.4", "Game Version", JOptionPane.INFORMATION_MESSAGE, gameIcon); // Open new JOptionPane | Displays Game Version Information		
		
			else {	
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the game?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE ,gameIcon) == JOptionPane.YES_OPTION) { // If User Clicks Yes
					
					gameTimer.stopTimer(); // Stop Timer
					loadMainMenu(); // Call 'loadMainMenu'
					JOptionPane.showMessageDialog(null, "Type and Go Version\nCurrent Game Version: 1.4", "Game Version", JOptionPane.INFORMATION_MESSAGE, gameIcon); // Open new JOptionPane | Displays Game Version Information		
					
				}
			}
		
		if (e.getSource().equals(subMen4)) { // If 'menu3' OR 'bttn3' is Clicked
			
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want\nto exit the game?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE ,gameIcon) == JOptionPane.YES_OPTION) // If User Clicks Yes
			    System.exit(0);	// Close Application
			
		}
		
		if (e.getSource().equals(subMen5)) { // If 'subMen5' is clicked
			
			frame.clearFrame(); // Clear GUI's JFrame 'frame'
			frame.makeRulesMenu(setBttn2); // Calls 'makeRulesMenu' from 'frame' | Parameters ['setBttn2']
			frame.setVisible(true);	// Set 'frame' Visibility to True
			
		}
		
		if (e.getSource().equals(subMen6)) { // If 'subMen6' is clicked
			
			frame.clearFrame(); // Clear GUI's JFrame 'frame'
			frame.makeLeaderboardMenu(setBttn2); // Calls 'makeLeaderboardMenu' from 'frame' | Parameters ['lbButton1, lbButton2, lbButton3']
			frame.setVisible(true);	// Set 'frame' Visibility to True
			
		}
	}
	}}