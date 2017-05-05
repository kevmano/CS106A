/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program draws a pyramid of rectangles. It uses 3 constants that can be changed to draw different-sized pyramids. The constants are the width of each
 * brick, the height of each brick, and the number of bricks in the bottom row of the pyramid. We use these constants to run a for loop and nested for loop
 * that build each row in a way such that each row is centered on the screen and contains one fewer brick than the row below it. Slides from lecture
 * were used in writing out this solution.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {
	private static final int BRICK_WIDTH = 32;			//Sets the constant of how wide each brick is
	private static final int BRICK_HEIGHT = 20;			//Sets the height of each brick
	private static final int BRICKS_IN_BASE = 14;		//Sets how many bricks will be in the bottom row of the pyramid

	public void run() {
		int w = getWidth();								//Finds the width of the window
		int h = getHeight();							//Finds the height of the window
		for (int i = BRICKS_IN_BASE; i >= 0; i--) {		//Runs a loop that builds 1 less brick on each row until the number of bricks reaches 0
			for (int j = 0; j <= i; j++) {				//Runs a loop that centers each row based on how many bricks are going to be built on that row
				double x = ((w / 2.0) - ((BRICK_WIDTH * BRICKS_IN_BASE - (BRICKS_IN_BASE - i) * BRICK_WIDTH)) / 2.0) - 0.5 * BRICK_WIDTH + j * BRICK_WIDTH;
				double y = h - BRICK_HEIGHT * (BRICKS_IN_BASE - i);
				add(new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT));
			}
		}
	}
}