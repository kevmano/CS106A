/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program utilizes graphics to draw a person with a soccer ball near a soccer goal. It contains GOval, GLine, and GRect, as well as 3 different
 * colors other than black and white (green, dark gray, and light gray). Lecture slides were used, mainly for shape and color nomenclature, to help 
 * draw this picture.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Artistry extends GraphicsProgram {
	public void run() {
		setSize(800,700);
		
		//This creates the green grass of the soccer field.
		GRect grass = new GRect(0,500,800,200);
		grass.setFilled(true);
		grass.setFillColor(Color.green);
		add(grass);
		
		add(new GOval(160,290,60,60));		//Outline of face
		add(new GOval(175,305,10,10));		//Left eye
		add(new GOval(195,305,10,10));		//Right eye
		add(new GOval(187,322,5,5));		//Nose
		add(new GLine(180,335,200,335));	//Middle of mouth
		add(new GLine(175,330,180,335));	//Left corner of mouth
		add(new GLine(200,335,205,330));	//Right corner of mouth
		add(new GLine(190,350,190,440));	//Torso
		add(new GLine(190,395,145,430));	//Left arm
		add(new GLine(190,395,225,430));	//Right arm
		add(new GLine(190,440,165,500));	//Left leg
		add(new GLine(190,440,215,500));	//Right leg
		
		//This creates a dark gray-colored soccer ball.
		GOval ball = new GOval(265,470,30,30);
		ball.setFilled(true);
		ball.setFillColor(Color.DARK_GRAY);
		add(ball);
		
		//This creates the outside boundary of the soccer goal.
		GRect goal = new GRect(365,225,350,275);
		goal.setFilled(true);
		goal.setFillColor(Color.LIGHT_GRAY);
		add(goal);
		
		//This creates the inside boundary of the soccer goal.
		GRect insideGoal = new GRect(385,245,310,255);
		insideGoal.setFilled(true);
		insideGoal.setFillColor(Color.white);
		add(insideGoal);
		
		//This creates the lines making up the net for the goal from top to bottom.
		for (int i = 0; i < 20; i++) {
			add(new GLine(400 + 15 * i,245,400 + 15 *i,500));
		}
		
		//Creates the lines making up the net for the goal from left to right.
		for (int i = 0; i < 17; i++) {
			add(new GLine(385,260 + 15 * i,695,260 + 15 * i));
		}
		
		//Signature
		add(new GLabel("Artistry by Kevin Manouchehri",623,630));
	}
}
