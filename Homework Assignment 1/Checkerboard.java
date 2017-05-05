/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program sets up a checkerboard-like pattern in a rectangular world. It works for worlds of all different sizes. The solution involves setting checkers
 * down in the west-to-east direction. After each row is completed, Karel then returns from the east end of the row to the west to advance to the next row.
 * Both the Karel reader and lecture were used as aid in developing this solution.
 */

import stanford.karel.*;

public class Checkerboard extends SuperKarel {

	public void run() {
		startCheckersOnFirst();
		afterTheFirstRow();
	}
	
	/* 
	 * Builds an alternating pattern of checkers on the first row.
	 * Pre: Karel is on the far west corner of the row.
	 * Post: Karel is on the far east corner of the row, having creating an alternating pattern of beepers.
	 */
	public void startCheckersOnFirst() {
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();			// Creates an alternating pattern of beepers.
			}
		}
	}
	
	/*
	 * Builds all of the rows in an alternating pattern after the first row.
	 */
	public void afterTheFirstRow() {
		while (leftIsClear()) {
			goBack();
			turnRight();
			if (beepersPresent()) {
				startCheckersOnSecond();			// Rows falling under this start the alternating beeper pattern on the second corner of the row.
			} else {
				move();
				turnRight();
				startCheckersOnFirst();				// Rows falling under this mimic the pattern of beepers from the first row.
			}
		}
	}
	
	/* 
	 * Pre: Karel is on the east end of the board after just laying down a row of checkers.
	 * Post: Karel is back on the west end of the board in the same row.
	 */
	public void goBack() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
	}
	
	/*
	 * This is the second pattern of checkers that go on rows after the pattern of the first row (rows 2, 4, 6, 8, etc.).
	 * It differs from the first pattern in that the first beeper is placed on the second corner of the row, rather than the first.
	 */
	public void startCheckersOnSecond() {
		move();
		turnRight();
		while (frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
	}
}