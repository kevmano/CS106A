// TODO: comment this file (if you choose to write it)
//       (This file is for an optional extra credit feature.)

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	private static final int scaffoldHeight = 350;
	private static final int scaffoldWidth = 175;
	private static final int ropeHeight = 20;
	private static final int headRadius = 40;
	private static final int torsoLength = 140;
	private static final int upperArmWidth = 80;
	private static final int lowerArmHeight = 40;
	private static final int upperLegWidth = 50;
	private static final int footWidth = 30;
	
	public void drawMan(int guessesLeft) {
		removeAll();
		if (guessesLeft <= 8) {
			drawScaffold();
		}
		if (guessesLeft <= 7) {
			drawHead();
		}
		if (guessesLeft <= 6) {
			drawTorso();
		}
		if (guessesLeft <= 5) {
			drawRightArm();
		}
		if (guessesLeft <= 4) {
			drawLeftArm();
		}
		if (guessesLeft <= 3) {
			drawRightLeg();
		}
		if (guessesLeft <= 2) {
			drawLeftLeg();
		}
		if (guessesLeft <= 1) {
			drawRightFoot();
		}
		if (guessesLeft == 0) {
			drawLeftFoot();
		}
	}
	
	public void drawScaffold() {
		double vertScaffoldX = getWidth() / 4;
		double vertScaffoldY = getHeight();
		GLine vertScaffold = new GLine(vertScaffoldX, vertScaffoldY, vertScaffoldX, vertScaffoldY - scaffoldHeight);
		add(vertScaffold);
		double horizScaffoldX = getWidth() / 4;
		double horizScaffoldY = vertScaffoldY - scaffoldHeight;
		GLine horizScaffold = new GLine(horizScaffoldX, horizScaffoldY, horizScaffoldX + scaffoldWidth, horizScaffoldY);
		add(horizScaffold);
		double ropeX = horizScaffoldX + scaffoldWidth;
		double ropeY = horizScaffoldY;
		GLine rope = new GLine(ropeX, ropeY, ropeX, ropeY + ropeHeight);
		add(rope);
	}
	
	public void drawHead() {
		double x = getWidth() / 4 + scaffoldWidth - headRadius;
		double y = getHeight() - scaffoldHeight + ropeHeight;
		GOval head = new GOval(x, y, headRadius * 2.0, headRadius * 2.0);
		add(head);
	}
	
	public void drawTorso() {
		double x = getWidth() / 4 + scaffoldWidth;
		double y = getHeight() - scaffoldHeight + ropeHeight + headRadius * 2.0;
		GLine torso = new GLine(x, y, x, y + torsoLength);
		add(torso);
	}
	
	public void drawRightArm() {
		double upperX = getWidth() / 4 + scaffoldWidth;
		double upperY = getHeight() - scaffoldHeight + ropeHeight + headRadius * 2.0 + torsoLength / 4;
		GLine upperArm = new GLine(upperX, upperY, upperX - upperArmWidth, upperY);
		add(upperArm);
		double lowerX = upperX - upperArmWidth;
		double lowerY = upperY;
		GLine lowerArm = new GLine(lowerX, lowerY, lowerX, lowerY + lowerArmHeight);
		add(lowerArm);
	}
	
	public void drawLeftArm() {
		double upperX = getWidth() / 4 + scaffoldWidth;
		double upperY = getHeight() - scaffoldHeight + ropeHeight + headRadius * 2.0 + torsoLength / 4;
		GLine upperArm = new GLine(upperX, upperY, upperX + upperArmWidth, upperY);
		add(upperArm);
		double lowerX = upperX + upperArmWidth;
		double lowerY = upperY;
		GLine lowerArm = new GLine(lowerX, lowerY, lowerX, lowerY + lowerArmHeight);
		add(lowerArm);
	}
	
	public void drawRightLeg() {
		double upperX = getWidth() / 4 + scaffoldWidth;
		double upperY = getHeight() - scaffoldHeight + ropeHeight + headRadius * 2.0 + torsoLength;
		GLine upperLeg = new GLine(upperX, upperY, upperX - upperLegWidth, upperY);
		add(upperLeg);
		double lowerX = upperX - upperLegWidth;
		double lowerY = upperY;
		GLine lowerLeg = new GLine(lowerX, lowerY, lowerX, getHeight() - 10);
		add(lowerLeg);
	}
	
	public void drawLeftLeg() {
		double upperX = getWidth() / 4 + scaffoldWidth;
		double upperY = getHeight() - scaffoldHeight + ropeHeight + headRadius * 2.0 + torsoLength;
		GLine upperLeg = new GLine(upperX, upperY, upperX + upperLegWidth, upperY);
		add(upperLeg);
		double lowerX = upperX + upperLegWidth;
		double lowerY = upperY;
		GLine lowerLeg = new GLine(lowerX, lowerY, lowerX, getHeight() - 10);
		add(lowerLeg);
	}
	
	public void drawRightFoot() {
		double x = getWidth() / 4 + scaffoldWidth - upperLegWidth;
		double y = getHeight() - 10;
		GLine rightFoot = new GLine(x, y, x - footWidth, y);
		add(rightFoot);
	}
	
	public void drawLeftFoot() {
		double x = getWidth() / 4 + scaffoldWidth + upperLegWidth;
		double y = getHeight() - 10;
		GLine leftFoot = new GLine(x, y, x + footWidth, y);
		add(leftFoot);
	}
	// TODO: write this file (optional)
	//       (treat it like a GraphicsProgram and add() graphical objects to it)
	
}
