/*
* Alexander Platon, etc.
* Guess The Number, HW 2
* Last Edited Date: September 28, 2022
* alp6141@psu.edu, etc.
*/

package Controller; // Within 'Controller' Package

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The TypingGame Class is the main
 * class that runs the program and contains
 * all of the logic.
 * @author alexplaton, etc.
 */
public class TypingGame {

	// Class Variables | Private
	
	// Class Variables | Public
	
	public TypingGame() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		// Setting up the GUI 
		guiSetUp(); // Calls 'guiSetUp' method
		
	}
	
	public void guiSetUp() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		new GUIController(); // Calls 'MainGUI' Constructor
		
	}
	
}
