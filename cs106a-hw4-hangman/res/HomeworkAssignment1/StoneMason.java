/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program fills in the missing stones on a variable number of columns. Karel fills in the missing stones on a column in an upward fashion, turns around
 * and returns back to the bottom of the column, and then moves to the next column to repeat the process.The Karel reader, as well as lecture notes, were 
 * used for help on this problem.
 */

import stanford.karel.*;

public class StoneMason extends SuperKarel {

	public void run() {
		findAndBuildColumn();
		lastColumn();
	}
	
	/* 
	 * This method starts at the first column, fills in the missing stones, finds the next column, and then repeats the building process.
	 * Pre: Karel is at the bottom of the first column furthest west position on the board.
	 * Post: Karel is at the bottom of the final column at the furthest east position on the board.
	 */
	public void findAndBuildColumn() {
		while (frontIsClear()) {
			turnLeft();
			buildColumn();
			findNextColumn();
		}
	}
	
	/* 
	 * This method fills in the missing stones on the column Karel is on.
	 */
	public void buildColumn() {
		if (noBeepersPresent()) {
			putBeeper();			// If the first corner on the bottom is missing a stone, this fills it in.
		}
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();		// Fills in the missing stones.
			}
		}
	}
	
	/*
	 * This tells Karel to find the next column to build 4 corners over, as long as a wall is not in the way.
	 */
	public void findNextColumn() {
		turnRight();
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
		move();
		move();
		move();
		move();					// Moves to the next column 4 units over.
	}
	
	/* 
	 * Builds the final column, which mimics a fencepost problem as the other methods do not build this column.
	 * Pre: Karel is at the bottom of the column furthest east on the board.
	 * Post: Karel is at the top of that column, having filled in the missing stones.
	 */
	public void lastColumn() {
		turnLeft();
		buildColumn();
	}
}
