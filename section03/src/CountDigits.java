/*
 * CS 106A, Section 3 Pre-section problem
 */

import acm.program.*;

public class CountDigits extends ConsoleProgram {
	public void run() {
		countDigits(5163);
		countDigits(42);
		//println(countDigits(5163));        // 4
		//println(countDigits(42));          // 2
		//println(countDigits(1000470));     // 7
		//println(countDigits(1));           // 1
		//println(countDigits(6));           // 1
		
		// optional: negative numbers and zero
		//println(countDigits(-42));         // 2
		//println(countDigits(-10203040));   // 8
		//println(countDigits(-6));          // 1
		//println(countDigits(0));           // 1
	}
	
	public void countDigits(int n) {
		int num = 0;
		while (n > 0) {
			n /= 10;
			num++;
		}
		println("The number of digits is " + num + ".");
	}
	
}
