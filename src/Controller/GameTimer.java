/*
* Alexander Platon, etc.
* Typing Game Project | IST 311
* Last Edited Date: November 29th, 2022
* alp6141@psu.edu, etc.
*/

package Controller; // Within Package Controller 

import java.awt.event.ActionEvent; // Import ActionEvent Class
import java.awt.event.ActionListener; // Import ActionListener Class
import javax.swing.JLabel; // Import JLabel Class
import javax.swing.JOptionPane;
import javax.swing.Timer; // Import Timer Class

/*
 * This is the Timer Class. This Class handles all of
 * the in game time functions. This Class is neatly 
 * displayed within a JLabel, within the GUI. (North Panel)
 */
public class GameTimer { // Class Timer

	// Class Variables | Private
	private int seconds;
	private Timer timer; // New Integer 'time'
	
	
	/*
	 * This is Timer's Constructor.
	 * This Constructor is designed to set up an 
	 * in game timer that is displayed for the user
	 * within the GUI window.
	 * Paramters [JLabel 'timerLbl', Integer 'time']
	 */
	public GameTimer(JLabel timerLbl, int time) {
		
		// Set Up In Game Timer
		seconds = time; // Set 'seconds' to 60
		timerLbl.setText("Time: " + seconds);
		timer = new Timer(1000, new ActionListener() { // Creates New Timer 'timer'
		
			/*
			 * 'actionPerformed' is called continuously until
			 * 'seconds' reaches 0
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (seconds >= 0) {// If 'seconds' is greater than 0
					timerLbl.setText("Time: " + seconds);
					seconds--; // Subtract 1 from 'seconds'	
				}
				else { // Otherwise
					timer.stop(); // Stop the Timer
					JOptionPane.showConfirmDialog(null, "Out of Time!", "You ran out of Time!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE); // Open JOptionPane that displays an the user ran out of time
				}
			}	
		});
	}
	
	/*
	 * This is Timer's 2nd Constructor.
	 * This Constructor is designed to set up an 
	 * logo timer that is hidden from the user.
	 * Used for progam time purposes.
	 * Parameters [integer 'time']
	 */
	public GameTimer(int time) {
		
		// Set Up In Game Timer
		seconds = time; // Set 'seconds' to 60		
		timer = new Timer(1000, new ActionListener() { // Creates New Timer 'timer'

			/*
			 * 'actionPerformed' is called continuously until
			 * 'seconds' reaches 0
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--; // Subtract 1 from 'seconds'	
			}	
		});	
	}
	
	/*
	 * The 'startTimer' method starts the timer
	 * within the game.
	 */
	public void startTimer() {
		timer.start(); // Start the Timer
		
	}
	
	/*
	 * The 'stopTimer' method stops
	 * the time at its current position.
	 */
	public void stopTimer() {
		timer.stop(); // Stop the Timer
	}
	
	/*
	 * The 'getTime' method simply returns
	 * the time at its current position.
	 */
	public int getTime() {	
		return seconds; // Returns 'time'
	}
	
	/*
	 * The 'setTime' method simply sets
	 * the time to what is sent over through the parameters.
	 * Parameters [time]
	 */
	public void setTime(int time) {
		seconds = time; // Set 'time' to Parameter
	}
	
}