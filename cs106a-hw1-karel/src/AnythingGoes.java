/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program creates a smiley face on the board using Karel's beepers. It involves first drawing a smile near the bottom of the world, then moving up to 
 * the walls set up where the nose is supposed to be. The nose is filled in, and then Karel moves on to creating eyes with the beepers. No outside resources
 * were used in developing this solution. :)
 */

import stanford.karel.*;

public class AnythingGoes extends SuperKarel {
	
	public void run() {
		beeperRow();
		bottomToTop();
		beeperRow();
		topToBottom();
	}
	
	public void beeperRow() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
				move();
			}
			}
		putBeeper();
		}

	public void bottomToTop() {
		turnAround();
		while (frontIsClear()) {
			move();
			turnRight();
			move();
			putBeeper();
			turnLeft();
		}
		turnAround();
	}
	
	public void topToBottom() {
		turnAround();
		while (frontIsClear()) {
			move();
			turnLeft();
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
			turnRight();
		}
	}
	}
//		makeSmile();
//		makeNose();
//		makeEyes();
//	}
//	
//	/*
//	 * This creates a smile near the bottom of the board.
//	 */
//	public void makeSmile() {
//		turnLeft();
//		for (int i = 0; i < 3; i++) {			// Karel moves to where the top part of the smile is.
//			move();
//		}
//		leftSideOfSmile();
//		middleSmile();
//		rightSideOfSmile();		
//	}
//	
//	/*
//	 * This creates the nose part of the smiley face by using the outline of the walls in the world as a guide.
//	 */
//	public void makeNose() {
//		turnLeft();
//		move();
//		turnLeft();
//		while (frontIsClear()) {
//			move();
//		}
//		turnAround();
//		while (leftIsBlocked()) {
//			putBeeper();
//			move();
//		}
//	}
//	
//	/*
//	 * This method makes the eyes of our smiling face. It involves placing two beepers on two different sides of the face near the top of the world.
//	 */
//	public void makeEyes() {
//		turnLeft();
//		for (int j = 0; j < 3; j++) {
//			move();
//		}
//		putBeeper();
//		turnRight();
//		move();
//		putBeeper();
//		turnAround();
//		for (int k = 0; k < 4; k++) {
//			move();
//		}
//		for (int m = 0; m < 2; m++) {
//			putBeeper();
//			move();
//		}
//	}
//	
//	/*
//	 * This creates the left half of the smile.
//	 * Pre: Karel is in the most northwest part of the smile.
//	 * Post: Karel is in the most southern part of the smile.
//	 */
//	public void leftSideOfSmile() {
//		turnRight();
//		putBeeper();
//		while (rightIsClear()) {
//			turnRight();
//			move();
//			turnLeft();
//			move();
//			putBeeper();			
//		}
//	}
//	
//	/*
//	 * This places beepers on the bottom row of the world to make the middle part of our smile.
//	 */
//	public void middleSmile() {
//		for (int k = 0; k < 3; k++) {
//			move();
//			putBeeper();
//		}
//	}
//	
//	/*
//	 * Karel places beepers to create the right half of the smile.
//	 */
//	public void rightSideOfSmile() {
//		while (frontIsClear()) {
//			turnLeft();
//			move();
//			turnRight();
//			move();
//			putBeeper();			
//		}
//	}
