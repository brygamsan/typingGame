/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/


import Controller.GUIController; // Imports 'GUIController' | Imported because of Different Package Location

/**
 * Application is a basic runner class, it 
 * is what calls the code within the game to run 
 * and display output to the GUI legibly.
 * @author alexplaton, etc.
 */
public class Application { // Class Application
	
	/*
	 * This is TypeAndGo's 'main' method.
	 * This is the method that runs the application
	 * at startup.
	 */
	public static void main (String args []) {
		
		runGame(); // Call 'runGame' Method
		
	}
	
	/*
	 * The 'runGame' method is what starts
	 * the actual game at startup. Calls the
	 * class that opens the JFrame which then starts 
	 * the controller class.
	 */
	public static void runGame() {
		
		new GUIController(); // new GUIController Class	
		
	}
}