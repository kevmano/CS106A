/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program takes a user input of exam scores and determines the highest score, lowest score, and average of the set of scores, as well as the number
 * of students who scored 59 or lower (deemed a failure). Once -1 is put in as an exam score, the program stops running, and the maximum, minimum, average,
 * and number of students who failed are calculated. An input of -1 is not included in any of the calculations being made. Lecture slides were used to help
 * me with this solution.
 */

import acm.program.*;

public class ExamScores extends ConsoleProgram {
	public void run() {
		println("This program computes stats about exam scores.");
		double sum = 0;
		int length = 0;
		int fail = 0;
		int max = 0;
		int min = 100000000;
		int n = readInt("Next exam score (or -1 to quit)? ");		//Asks for a user input of the exam score
		if (n == -1) {
			println("No scores were entered.");
		}
		else {
		while (n != -1) {					//Once -1 is entered, the program no longer runs.
			sum += n;
			length += 1;
			if (n <= 59 && n >= 0) {		//If the score is 59 or lower, 1 is added to the number of failures.
				fail += 1;
			}
			if (n > max) {					//If the new n is greater than the maximum to date, the new n becomes the maximum.
				max = n;
			}
			if (n < min) {					//If the new n is lower than the lowest score to date, the new n becomes the minimum.
				min = n;
			}
			n = readInt("Next exam score (or -1 to quit)? ");		//Asks for a user input of the exam score
		}
		println("Highest score = " + max);
		println("Lowest score = " + min);
		println("Average = " + (sum / length));
		println(fail + " student(s) failed the exam.");
		}
	}
}
