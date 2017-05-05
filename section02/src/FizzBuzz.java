/*
 * CS 106A, Section 2 Pre-section problem
 */

import acm.program.*;

public class FizzBuzz extends ConsoleProgram {
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				print("Fizz");
			}
			else if (i % 5 == 0 && i % 3 != 0) {
				print("Buzz");
			}
			else if (i % 3 ==0 && i % 5 ==0) {
				print("FizzBuzz");
			}
			else {
				print(i);
			}
			print(" ");
		}
		
	}
}
