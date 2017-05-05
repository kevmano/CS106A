/*
 * Name: Kevin Manouchehri	Section: Section: Thaminda Edirisooriya Thursday 10:00
 * This program builds an object that resembles a rocket utilizing a given class constant. Depending on the class constant, the rocket can be scaled
 * both up and down. It builds the rocket in pieces using methods. The top and bottom of the rocket are built using the same methods because they look
 * the same. There are two identical parts that separate the top and bottom of the rocket from the middle of the rocket, so they are built with 1 method
 * as well. The middle of the rocket is broken up into 2 parts that are mirror images of one another. All methods except the connector one utilized
 * the idea of nested for loops. Slides from lecture were used to help develop a solution.
 */

import acm.program.*;

public class Rocket extends ConsoleProgram {
	private static final int SIZE = 5;		//Sets the class constant as 5
	public void run() {
		endOfRocket();						//Builds the top of the rocket
		connector();						//Builds the part between the top and middle of the rocket
		upperRocketBody();					//Builds the top half of the middle of the rocket
		lowerRocketBody();					//Builds the lower half of the middle of the rocket
		connector();						//Builds the part between the bottom and middle of the rocket
		endOfRocket();						//Builds the bottom of the rocket
	}
	
	/*
	 * This method builds both the top and bottom parts of the rocket. 
	 * It uses a combination of forward slashes, backward slashes, and spaces to create a triangular-shaped piece of the rocket.
	 */
	public void endOfRocket() {
		for (int i = 1; i <= SIZE; i++) {
			for (int j = 1; j <= SIZE - i + 1; j++) {
				print(" ");
			}
			for (int j = 1; j <= i; j++) {
				print("/");
			}
			for (int j = 1; j <= i; j++) {
				print("\\");
			}
			for (int j = 1; j <= SIZE - i + 1; j++) {
				print(" ");
			}
			println();
		}
	}
	
	/*
	 * This builds the part that separates the ends of the rocket with the middle. It places a plus at each end with equal signs in between.
	 * The number of equal signs drawn are 2 times the class constant SIZE being used.
	 */
	public void connector() {
		print("+");
		for (int i = 1; i <= SIZE; i++) {
			print("==");
		}
		print("+");
		println();
	}
	
	/*
	 * Builds the top half of the middle part of the rocket.
	 * This features an increasing number of alternating forward and backward slashes, where the final row features the number of slashes of each type
	 * equal to the class constant SIZE.
	 */
	public void upperRocketBody() {
		for (int i = 1; i <= SIZE; i++) {
			print("|");
			for (int j = 1; j <= SIZE - i; j++) {		//Fills the space not taken up by the slashes.
				print(".");
			}
			for (int k = 1; k <= i; k++) {				//Prints alternating forward and backward slashes
				print("/");
				print("\\");
			}
			for (int j = 1; j <= SIZE - i; j++) {		//Fills the space not taken up by the slashes.
				print(".");
			}
			print("|");
			println();
		}
	}
	
	/*
	 * Builds the lower half of the middle part of the rocket.
	 * This is essentially a mirror image of the top half, where the first row features the number of slashes of each type equal to the class constant SIZE.
	 */
	public void lowerRocketBody() {
		for (int i = SIZE; i >= 1; i--) {
			print("|");
			for (int j = 1; j <= SIZE - i; j++) {		//Fills the space not taken up by the slashes.
				print(".");
			}
			for (int k = i; k >= 1; k--) {				//Prints alternating forward and backward slashes
				print("\\");
				print("/");
			}
			for (int j = 1; j <= SIZE - i; j++) {		//Fills the space not taken up by the slashes.
				print(".");
			}
			print("|");
			println();
		}
	}
}
