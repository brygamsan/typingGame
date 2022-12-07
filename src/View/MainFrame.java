/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/

package View; // Within 'View' Package

import javax.sound.sampled.AudioSystem; // Import AudioSystem Class
import javax.sound.sampled.Clip; // Import Clip Class
import javax.swing.*; // Imports Swing Classes
import Controller.GameTimer; // Import GameTimer Class
import java.awt.*; // Imports Awt Classes
import java.io.File; // Import File Class


/**
 * The MainFrame Class is what sets up and 
 * displays the GUI in a neatly organized window.
 * @author alexplaton, etc.
 */
public class MainFrame extends JFrame { // Class MainFrame | Extends JFrame
	
	// Class Variables | Private 
	private JPanel logoPanel; // New JPanel 'logoPanel'
	private JLabel logo; // New JLabel 'logo'
	private Font font; // New Font 'font' 
	private NorthPanel panelNth; // New NorthPanel 'panelNth'
	private CenterPanel panelCntr; // New CenterPanel 'panelCntr'
	private SouthPanel panelSth; // New SouthPanel 'panelSth'
	private ImageIcon gameIcon; // New ImageIcon 'gameIcon'
	private GameTimer logoTimer; // New GameTimer 'logoTimer'
	private boolean inGame; // New Boolean 'inGame'
	private Clip clip1, clip2, clip3, clip4; // New Clip 'clip1', 'clip2', 'clip3', 'clip4'
	
	// Class Final Variables
	private final int LOGO_SOUND = 0;
	private final int MENU_MUSIC = 1;
	private final int GAME_MUSIC = 2;
	private final int LEADERBOARD_MUSIC = 3;
	
	/*
	 * This is MainFrame's Contsructor Method.
	 * This Constructor is designed to set up the main
	 * JFrame for the game. It holds all of the panels and buttons
	 * so the user can interact with the GUI.
	 */
	public MainFrame(JButton bttn1, JButton bttn2, JButton bttn3) {
		
		// Setting up MainFrame | Frame
		super("Type and Go Game"); // Calls JFrame conductor | Type and Go is working title
		gameIcon = new ImageIcon("Icon.png"); // New ImageIcon 'gameIcon' | Stays On After Export
		setIconImage(gameIcon.getImage()); // Set Game Icon to 'gameIcon'
		setSize(850,475); // Set JFrame Size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set JFrame to Exit on Close
		setResizable(false); // Disable Resizeability
		inGame = false; // Set 'inGame' to False
		
		// Load Start Logo
		logoTimer = new GameTimer(2); // New GameTimer for 15 Seconds
		font = new Font("ZapfDingbats", Font.PLAIN, 30); // New custom Font 'font' 
		makeBlankScreen(); // Calls 'makeLogoScreen'
		
		try { // Try to
			Thread.sleep(2000); // Have Program Hault for 2 Seconds
			makeLogoScreen(); // Call 'makeLogoScreen'
			playGameMusic(LOGO_SOUND); // Call 'playSound' | Parameters [LOGO_SOUND]	
			Thread.sleep(5000); // Have Program Hault for 5 Seconds
					
		} catch (InterruptedException e) { // If InterruptedException is Caught
			System.out.println("Faital Error, Game Files Maybe Corrupted!"); // Print Error
			e.printStackTrace(); // Print the Error To Console
		}
		
		if (logoTimer.getTime() <= 1) { // If 'logoTimer' is 0	
			logoTimer.stopTimer(); // Stop 'logoTimer'
			makeMainMenu(bttn1, bttn2, bttn3); // Calls 'makeMainMenu' method | Parameters [bttn1, bttn2, bttn3]
			playGameMusic(MENU_MUSIC); // Call 'playSound' | Parameters [MENU_MUSIC]
		}
		
		// Set JFrame's Visibility
		setVisible(true); // Set Visibility to True
		
	}
		
	/*
	 * The 'makeBlankScreen' is a method that runs once
	 * in the very beginning of the game to show a blank screen
	 * before the game loads in.
	 */
	private void makeBlankScreen() {
		
		// Setting Up 'logoPanel'
		logoPanel = new JPanel(); // Set 'logoPanel' as new JPanel
		logoPanel.setLayout(new GridBagLayout()); // Set 'logoPanel' Layout to GridBagLayout
		logoPanel.setBackground(new Color(0, 0, 0)); // Set Background Color to Black
		
		// Add Objects to MainFrame
		add(logoPanel);
		
		// Set JFrame's Visibility & Location
		setLocationRelativeTo(null); // Forces Location to Middle of Screen | This is only called here so that the screen never moves when loading new objects
		setVisible(true); // Set Visibility to True
		
	}
	
	/*
	 * The 'makeLogoScreen' is a method that runs once
	 * in the very beginning of the game to show a picture of
	 * the groups logo. Nothing More
	 */
	private void makeLogoScreen() { 
		
		
		// Starting Timer
		logoTimer.startTimer(); // Start the Timer
		
		// Setting Up 'logo'
		logo = new JLabel("The Four Horsmen Coding INC."); // Set 'logo' text | Text: "The Four Horsemen Coding INC."
		logo.setBackground(new Color(225, 225, 225)); // Set Color to Custom Color | Color [225, 225, 225), White
		logo.setFont(font);	// Set 'logo' Font	
		
		// Add Logo to 'logoPanel'
		logoPanel.add(logo); // Add 'logo' to 'logoPanel' 
		
		// Set JFrame's Visibility
		setVisible(true); // Set Visibility to True
		
	}
	
	/*
	 * The 'makeMainMenu' method is designed to setup 
	 * the settings menu for the user when they click on 
	 * the settings button on the Main Menu.
	 */
	public void makeMainMenu(JButton bttn1, JButton bttn2, JButton bttn3) {
		
		// Clear Frame
		clearFrame(); // Calls 'clearFrame'
		inGame = false; // Set 'inGame' to False
		
		// Start Music
		if (clip2 != null && !clip2.isActive())
			playGameMusic(MENU_MUSIC); // Call 'playSound' | Parameters [MENU_MUSIC]
		
		// Stop Music
		if (clip3 != null)  // If 'clip3' is NOT null
			clip3.stop(); // Stop 'clip3'	
		
		if (clip4 != null)  // If 'clip4' is NOT null
			clip4.stop(); // Stop 'clip4'
		
		
		// Add Objects to MainFrame
		panelNth = new NorthPanel(); // new NorthPanel 'panelNth'
		panelCntr = new CenterPanel(bttn1, bttn2, bttn3); // New CenterPanel 'panelCntr'
		panelSth = new SouthPanel(); // New SouthPanel 'panelSth'
		
		// Add to MainFrame
		add(panelNth, BorderLayout.NORTH); // Add 'panelNth' to MainFrame | Added to the North of BorderLayout
		add(panelCntr, BorderLayout.CENTER); // Add 'panelCntr' to MainFrame | Added to the Center of BorderLayout
			
	}
	
	/*
	 * The 'makeGameMenu' method is designed to setup 
	 * the game for the user when they click on 
	 * the play button on the Main Menu.
	 */
	public void makeGameMenu(GameTimer timer, JLabel timerLbl) {
		
		// Setting Up Game
		inGame = true; // Set 'inGame' to True
		clip2.stop();
		playGameMusic(GAME_MUSIC);
		
		// Call Panels
		panelNth.makeNorthPNLGame(timer, timerLbl); // Call 'makeNorthPNLGame' from 'panelNth'
		panelCntr.makeCenterPNLGame(); // Call 'makeCenterPNLGame' from 'panelCntr'
		panelSth.makeSouthPNLGame(); // Call 'makeSouthPNLGame' from 'panelSth'
		
		// Add to MainFrame
		add(panelNth, BorderLayout.NORTH); // Add 'panelNth' to MainFrame | Added to the North of BorderLayout
		add(panelCntr, BorderLayout.CENTER); // Add 'panelCntr' to MainFrame | Added to the Center of BorderLayout
		
	}
	
	/*
	 * The 'makeSettingsMenu' method is designed to setup 
	 * the settings menu for the user when they click on 
	 * the settings button on the Main Menu.
	 */
	public void makeSettingsMenu(JButton bttn1, JButton bttn2,JCheckBox cb1,JCheckBox cb2,JCheckBox cb3) {
		
		// Call Panels
		panelNth.makeNorthPNLSettings();  // Call 'makeNothPNLSettings' from 'panelSth'
		panelCntr.makeCenterPNLSettings(cb1, cb2, cb3); // Call 'makeCenterPNLSettings' from 'panelSth' | Parameters [cb1, cb2. cb3]
		panelSth.makeSouthPNLSettings(bttn1, bttn2); // Call 'makeSouthPNLSettings' from 'panelSth' | Parameters [bttn1, bttn2]
		
		// Add to MainFrame
		add(panelNth, BorderLayout.NORTH); // Add 'panelNth' to MainFrame | Added to the North of BorderLayout
		add(panelCntr, BorderLayout.CENTER); // Add 'panelCntr' to MainFrame | Added to the Center of BorderLayout
		add(panelSth, BorderLayout.SOUTH);// Add 'panelSth' to MainFrame | Added to the South of BorderLayout
		
	}
	
	/*
	 * The 'makeRulesMenu' method is designed to setup 
	 * the rules menu for the user when they click on 
	 * the rules button within the JMenu.
	 */
	public void makeRulesMenu(JButton bttn1) {
		
		// Call Panels
		panelNth.makeNorthPNLRules(); // Call 'makeNorthPNLRules' from 'panelNth'
		panelCntr.makeCenterPNLRules(); // Call 'makeCenterPNLRules' from 'panelCntr'
		panelSth.makeSouthPNLRules(bttn1); // Call 'makeSouthPNLRules' from 'panelSth' | Parameters [bttn1]
		
		// Add to MainFrame
		add(panelNth, BorderLayout.NORTH); // Add 'panelNth' to MainFrame | Added to the North of BorderLayout
		add(panelCntr, BorderLayout.CENTER); // Add 'panelCntr' to MainFrame | Added to the Center of BorderLayout
		add(panelSth, BorderLayout.SOUTH); // Add 'panelSth' to MainFrame | Added to the South of BorderLayout
		
	}
	
	/*
	 * The 'makeRulesMenu' method is designed to setup 
	 * the rules menu for the user when the clicks on 
	 * the rules button within the JMenu.
	 */
	public void makeLeaderboardMenu(JButton lbBttn1) {
		
		// Start Music
		playGameMusic(LEADERBOARD_MUSIC);
		
		// Stop Music 
		clip2.stop();
		
		// Call Panels
		panelNth.makeNorthPNLLeaderboard(); // Call 'makeNorthPNLRules' from 'panelNth'
		panelCntr.makeCenterPNLLeaderboard(); // Call 'makeCenterPNLRules' from 'panelCntr'
		panelSth.makeSouthPNLLeaderboard(lbBttn1); // Call 'makeSouthPNLRules' from 'panelSth' | Parameters [lbBttn1]
		
		// Add to MainFrame
		add(panelNth, BorderLayout.NORTH); // Add 'panelNth' to MainFrame | Added to the North of BorderLayout
		add(panelCntr, BorderLayout.CENTER); // Add 'panelCntr' to MainFrame | Added to the Center of BorderLayout
		add(panelSth, BorderLayout.SOUTH); // Add 'panelSth' to MainFrame | Added to the South of BorderLayout
		
	}
	
	/*
	 * The 'playGameMusic' method is designed to play music
	 * within the game. The music that are played correlate to 
	 * the parameter (Integer) send over by the progam.
	 * [0: Logo Sound, 1: Menu Music, 2: In Game Music, Leaderboard Music 3]
	 */
	private void playGameMusic(int selectedMusic) {
		
		// Create Files to Load
		File logoSound = new File("Logo Noise.wav"); // New File 'logoSound' set to 'Logo Noise.wav'
		File menuMusic = new File("Menu Music.wav"); // New File 'menuMusic' set to 'Game Music.wav'
		File gameMusic = new File("In Game Music.wav"); // New File 'gameMusic set to 'In Game Music.wav'
		File leaderBoardMusic = new File("Leaderboard Music.wav"); // New File 'leaderboardMusic' set to 'Leaderboard Music.wav'
		
		// Create Clips to Play
		
		if (selectedMusic == 0) { // if 'selectedSound' is equal to 0
			try { // Try to	
				clip1 = AudioSystem.getClip(); // New Clip 'clip1'
				clip1.open(AudioSystem.getAudioInputStream(logoSound)); // Open 'logoSound'
				clip1.start(); // Start 'clip1'	
			}
			catch(Exception e) { // If an Exception is Caught
				System.out.println("Critical Program Error!" + e); // Print the Exception
			}
		}
		
		else if (selectedMusic == 1) {	
			try { // Try to		
				clip2 = AudioSystem.getClip(); // New Clip 'clip2'
				clip2.open(AudioSystem.getAudioInputStream(menuMusic)); // Open 'menuMusic'
				clip2.start(); // Start 'clip2'	
			}
			catch(Exception e) { // If an Exception is Caught
				System.out.println("Critical Program Error!" + e); // Print the Exception
			}				
		}
		else if (selectedMusic == 2){
			try { // Try to		
				clip3 = AudioSystem.getClip(); // New Clip 'clip3'
				clip3.open(AudioSystem.getAudioInputStream(gameMusic)); // Open 'gameMusic'
				clip3.start(); // Start 'clip3'	
			}
			catch(Exception e) { // If an Exception is Caught
				System.out.println("Critical Program Error!" + e); // Print the Exception
			}			
		}
		else {
			try { // Try to		
				clip4 = AudioSystem.getClip(); // New Clip 'clip3'
				clip4.open(AudioSystem.getAudioInputStream(leaderBoardMusic)); // Open 'leaderBoardMusic'
				clip4.start(); // Start 'clip3'	
			}
			catch(Exception e) { // If an Exception is Caught
				System.out.println("Critical Program Error!" + e); // Print the Exception
			}
		}
	}
	
	/*
	 * The 'isInGame' method returns a boolean
	 * that tells the program if the user is 
	 * currently in game or not.
	 */
	public boolean isInGame() {
		return inGame;
	}
	
	/*
	 * The 'clearFrame' method is designed to clear
	 * the Main JFrame.
	 */
	public void clearFrame() {
		
		getContentPane().removeAll(); // Remove All Content
		revalidate(); // Reload JFrame
        repaint(); // Prepare JFrame
       
	}
}