/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This assignment places a single beeper at the center of the bottom row of the world. If the width of the world is even, the beeper is placed on either of
 * the two centers. The solution involves thinking of the problem like a shuttle run, where two beepers are first placed the furthest apart they can be. Then,
 * one corner at a time, they are brought closer together until they are next to each other. At that point, the beeper not directly in the center is picked
 * up. The Karel reader, lecture notes, and drawing the assignment and solution out on paper beforehand were used to solve this problem.
 */

import stanford.karel.*;

public class MidpointFinder extends SuperKarel {
	
	public void run() {
		setUp();
		findMiddle();
	}
	
	/*
	 * This puts a beeper on both the far west and far east ends of the first row.
	 * Pre: There are no beepers in the world.
	 * Post: There is a beeper on the far west corner of the first row, and there is one on the far east corner of the first row.
	 */
	public void setUp() {
		putBeeper();
		while (frontIsClear()) {
			move();
		}
		putBeeper();
	}
	
	/* 
	 * Finds the midpoint by moving the beepers one step closer to one another at a time until they are right next to each other.
	 * Pre: The beepers are on opposite corners of the first row.
	 * Post: The beepers are next to each other in the center, and one of the beepers (the non-centered one if the width is odd) is picked up.
	 */
	public void findMiddle() {
		turnAround();
		move();
		while (noBeepersPresent()) {
			move();
			if (beepersPresent()) {
				pickBeeper();
				turnAround();
				move();
				putBeeper();
				move();
			}
		}
		pickBeeper();
	}
}
