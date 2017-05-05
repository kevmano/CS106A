/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program moves Karel from the northwest corner of his house to one corner outside, retrieves a newspaper, and then returns Karel to his original
 * position. The Karel reader was utilized, mostly for nomenclature, when developing a solution to this problem.
 */

import stanford.karel.*;

public class CollectNewspaper extends SuperKarel {
	
	public void run() {
	moveToPaper();
	pickBeeper();
	goHome();
	}
	
	/* 
	 * Moves Karel to the newspaper while utilizing another method of turnRight.
	 * Pre: Karel is in the northwest corner of the house.
	 * Post: Karel is on the corner outside the house where the newspaper is.
	 */
	public void moveToPaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	// This turns Karel 90 degrees to the right.
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	/* 
	 * This method returns Karel to his original starting position.
	 * Pre: Karel is 1 corner outside the house.
	 * Post: Karel is in his original position in the northwest corner of the house.
	 */
	public void goHome() {
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		move();
		turnLeft();
		turnLeft();
	}
	
	 // Turns Karel around 180 degrees.
	public void turnAround() {
		turnLeft();
		turnLeft();
	}
}
