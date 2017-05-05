/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program creates and allows the user to play the game Breakout. A moving ball is deflected by a movable paddle in an attempt to remove all of the
 * bricks. The user has 3 turns to remove all of the bricks, and a turn is lost when the ball moves below the location of the paddle. To begin the game,
 * the user must click on the screen to initiate the ball's movement.
 */

import acm.graphics.*;     // GOval, GRect, etc.
import acm.program.*;      // GraphicsProgram
import acm.util.*;         // RandomGenerator
import java.applet.*;      // AudioClip
import java.awt.*;         // Color
import java.awt.event.*;   // MouseEvent

public class Breakout extends GraphicsProgram implements BreakoutConstants {
	private GRect paddle;
	private GOval ball;
	private static int NTURNS = 3;		//Number of turns the user has to eliminate all of the bricks
	private static double v_x;			//X-velocity of the ball
	private static double v_y;			//Y-velocity of the ball
	private static int brickCounter = NBRICK_ROWS * NBRICKS_PER_ROW;
	
	public void run() {
		setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		setUpBricks();
		setUpPaddle();
		gameTime();
	}
	
	/*
	 * This method creates rows of 5 different-colored bricks. It uses the constants specified in BreakoutConstants.java to determine how many rows
	 * of bricks will be built and how many bricks will be in each row. In this case, 10 rows of 10 bricks are built with each color taking up 2 consecutive
	 * rows.
	 */
	public void setUpBricks() {
		for (int i = 0; i < NBRICK_ROWS; i++) {					//Builds the number of rows based on the constant entered.
			for (int j = 0; j <= NBRICKS_PER_ROW - 1; j++) {	//Builds the number of bricks in each row based on the constant entered.
				double x = (BOARD_WIDTH - (NBRICKS_PER_ROW * BRICK_WIDTH) - ((NBRICKS_PER_ROW - 1) * BRICK_SEP)) / 2.0 + j *(BRICK_WIDTH + BRICK_SEP);
				double y = BRICK_Y_OFFSET + (i * BRICK_HEIGHT) + ((i-1) * BRICK_SEP);
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);	//Creates a rectangle that resembles a brick with coordinates that center the
				add(brick);													//row of bricks being made
				brick.setFilled(true);
				if (i < 2) {								//If the row being built is the 1st or 2nd from the top, the bricks are red.
					brick.setColor(Color.red);
					brick.setFillColor(Color.red);
				}
				else if (i > 1 && i < 4) {					//If the row is the 3rd or 4th from the top, the bricks are orange.
					brick.setColor(Color.orange);
					brick.setFillColor(Color.orange);
				}
				else if (i > 3 && i < 6) {					//If the row is the 5th or 6th from the top, the bricks are yellow.
					brick.setColor(Color.yellow);
					brick.setFillColor(Color.yellow);
				}
				else if (i > 5 && i < 8) {					//If the row is the 7th or 8th from the top, the bricks are green.
					brick.setColor(Color.green);
					brick.setFillColor(Color.green);
				}
				else {										//The final 2 rows of the group contain cyan bricks.
					brick.setColor(Color.cyan);
					brick.setFillColor(Color.cyan);
				}
			}
		}
	}
	
	/*
	 * This creates the black paddle the user will use to deflect the ball. 
	 */
	public void setUpPaddle() {
		double x = BOARD_WIDTH / 2 - PADDLE_WIDTH / 2;				//Sets the starting position of the paddle to be centered horizontally.
		double y = BOARD_HEIGHT - PADDLE_Y_OFFSET;					//Sets the paddle to be a certain height from the bottom.
		paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);		//Draws a rectangle that we will call the paddle at the coordinates specified.
		paddle.setFilled(true);
		paddle.setFillColor(Color.black);
		add(paddle);
		addMouseListeners();
	}
	
	/*
	 * This allows the paddle to be moved. As long as the mouse pointer is on the screen of the game, the paddle will move to the x-coordinate of the
	 * mouse.
	 */
	public void mouseMoved (MouseEvent move) {
		GObject paddle = getElementAt(move.getX(),BOARD_HEIGHT - PADDLE_Y_OFFSET);					//Finds the current location of the paddle.
		if (move.getX() < BOARD_WIDTH - PADDLE_WIDTH / 2 && move.getX() > PADDLE_WIDTH / 2 && paddle != null) {
			paddle.setLocation(move.getX() - PADDLE_WIDTH / 2,BOARD_HEIGHT - PADDLE_Y_OFFSET);		//Moves the center of the paddle to match the
		}																							//x-coordinate of the mouse.
	}

	/*
	 * This method specifies what happens when the game is actually played by the user. It creates the ball, waits for the user to click on the screen,
	 * and then plays the game.
	 */
	public void gameTime() {
		while (NTURNS > 0) {		//While the user still has not used up all 3 turns
			setUpBall();
			waitForClick();
			gamePlay();
		}
	}
	
	/*
	 * This creates the black ball that will moved and used to eliminate bricks.
	 */
	public void setUpBall() {
		ball = new GOval(BOARD_WIDTH / 2 - BALL_RADIUS, BOARD_HEIGHT / 2 - BALL_RADIUS, 2 * BALL_RADIUS, 2 * BALL_RADIUS);	//Sets the starting location
		ball.setFilled(true);																								//of the ball to be the center
		ball.setFillColor(Color.black);																						//of the screen.
		add(ball);
	}
	
	/*
	 * This method plays the game of Breakout once the user has clicked to start the game. It generates a random x-velocity and uses a pre-set y-velocity
	 * to move the ball. If the ball comes into contact with either of the side walls, the sign of its x-velocity is flipped. If it hits the top wall,
	 * its y-velocity is flipped. The method also checks for collisions with the paddle and the bricks. If the ball hits the bottom wall, the turn is
	 * ended, and the ball goes back to the center of the screen to wait to be played again. The game ends if no more bricks are present before the user
	 * has exhausted all 3 turns.
	 */
	public void gamePlay() {
		RandomGenerator randy = new RandomGenerator();
		v_x = 0.0;
		v_y = 3.0;
		while (true) {
			while (v_x >= -VELOCITY_MIN && v_x <= VELOCITY_MIN) {		//Generates a random x-velocity where the interval between the negative of the
				v_x = randy.nextDouble(-VELOCITY_MAX, VELOCITY_MAX);	//minimum velocity and the positive of it is excluded, as specified. 
			}
			ball.move(v_x, v_y);										//The ball is moved the number of pixels specified by the velocity values.

			if (ball.getX() < 0 || ball.getX() > BOARD_WIDTH - 2 * BALL_RADIUS) {	//If the ball hits a side wall, the x-velocity's sign is flipped.
				v_x = -v_x;
			}
			if (ball.getY() < 0) {													//If the ball hits the top wall, the y-velocity's sign is flipped.
				v_y = -v_y;
			}
			collision();
			pause(DELAY);												//Pauses the program to animate the game to make the ball move.
			if (ball.getY() > BOARD_HEIGHT) {							//If the ball hits the bottom wall, the turn is ended.
				endTurn();
				break;
			}

			if (brickCounter == 0) {									//If no more bricks are present before the user runs out of turns, the user has won.
				break;
			}
		}
	}
	
	/*
	 * This method checks for collisions between the ball and another object. It utilizes the coordinates found in getCollidingObject. If a collision is
	 * detected, the sign of the y-velocity is flipped.
	 */
	public void collision() {
		collider = getCollidingObject();
		if (collider != null && collider == paddle) {				//If the coordinates of the collider match those of the paddle.
			if (ball.getY() <= BOARD_HEIGHT - PADDLE_Y_OFFSET) {	//If the y-coordinate of the ball is either at or below the height of the paddle. This
				v_y = -v_y;											//helps prevent the ball from getting stuck to the paddle as it will only be deflected
			}														//when the ball is at the y-coordinate surface of the paddle.
		} else if (collider != null) {
			remove(collider);										//Removes a brick.
			v_y = -v_y;
			brickCounter--;
		}
	}
	
	/*
	 * This ends the turn once the ball has hit the bottom wall. The ball is removed so a new one can be placed in the center of the board, and the user
	 * now has 1 fewer turn.
	 */
	public void endTurn() {
		remove(ball);
		NTURNS--;
	}

	/*
	 * This finds if any of the 4 corners of the ball are in contact with an object on the screen. If a corner is in contact, it returns the coordinates
	 * of this contact to getColliding() and thus collider. The top right and left corners have a v_y term added to their y-coordinate to prevent the
	 * ball from getting glued to the paddle when the paddle is swiped quickly across.
	 */
	public GObject getCollidingObject() {
		//bottom left corner of the ball
		if (getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS) != null) {
			return getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		}
		//bottom right
		else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null) {
			return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		}
		//top right
		else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + v_y) != null) {  //Adding the v_y term prevents the ball from getting glued
			return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());				//to the paddle if the paddle is swiped quickly across.
		}
		//top left
		else if (getElementAt(ball.getX(), ball.getY() + v_y) != null) {
			return getElementAt(ball.getX(), ball.getY());
		} else {
			return null;
		}
	}
	
	private GObject collider;
	
}
