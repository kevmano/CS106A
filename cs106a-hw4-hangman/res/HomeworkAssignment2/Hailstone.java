/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This program displays the result of a "hailstone" sequence that is based on an inputted n value. If n is even, it is divided by 2. If n is odd,
 * it is multiplied by 3 and 1 is added to it. This process is continuously repeated until the number 1 is reached. At that point, the sequence is
 * complete, and the length of the sequence is given. The slides from lecture were used as aid to develop this solution.
 */

import java.awt.Font;

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		println("This program displays a series of numbers "
				+ "known as a hailstone sequence.");
		int length = 0;
		int n = readInt("Enter a number: ");		//Asks the user to input a number
		print(n);
		length += 1;
		while (n != 1) {
			if (n % 2 == 0) {			//If n is even
				n /= 2;					//Divides n by 2
				print(", " + n);		//Prints a comma and then the new n
				length += 1;			//Adds 1 to the length of the sequence

			} else {
				n = (n * 3) + 1;		//Multiplies n by 3 and adds 1
				print(", " + n);		//Prints a comma and then the new n
				length += 1;			//Adds 1 to the length of the sequence
			}
		}
		println();
		println("This hailstone sequence has length " + length + ".");
	}
}