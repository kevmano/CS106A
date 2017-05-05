/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program draws 3 targets of 3 different sizes. The targets are composed of alternating circles of red and white. By parameterizing the drawing
 * of a target, we can use the same method to draw multiple targets. All we have to do is change the value of the parameters we set, which in this case
 * are the size of the outer circle, the x-value of the top-left corner of the outer circle, the y-value of the top-left corner of the outer circle, and 
 * the number of circles we would like to have to make up the target. Lecture slides were to help create the solution to this problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Targets extends GraphicsProgram {
	public void run() {
		setSize(550, 400);
		target(100, 0, 0, 5);			//Order goes size of target, x-value of the top-left corner of the outer circle,
		target(200, 120, 40, 5);		//y-value of the top-left corner of the outer circle, and number of concentric circles to be used.
		target(128, 350, 20, 8);
	}

	public void target(int size, int startx, int starty, int numCircles) {	//Parameterizes the targets with the parameters being the size, starting x and
																			//y values, and the number of concentric circle to be drawn.
		for (int circleNum = 0; i <= totNumCircles - 1; i++) {
			int x = startx + (size / (2 * totNumCircles)) * i;				//Finds the x-value of the top-left corner of each successive circle.
			int y = starty + (size / (2 * totNumCircles)) * i;				//Finds the y-value of the top-left corner of each successive circle.
			int dimension = size - (size / totNumCircles) * i;				//Finds the size that each successive circle will be.
			if (circleNum % 2 == 0) {										//If the circle number (counting from the outside in) is even, a red circle will
				GOval redCircle = new GOval(x, y, dimension, dimension);	//be drawn.
				redCircle.setFilled(true);
				redCircle.setFillColor(Color.red);
				add(redCircle);
			} else {														//If the circle number is odd, a white circle will be drawn.
				GOval whiteCircle = new GOval(x, y, dimension, dimension);
				whiteCircle.setFilled(true);
				whiteCircle.setFillColor(Color.white);
				add(whiteCircle);
			}
		}
	}
}
