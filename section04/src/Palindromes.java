/*
 * CS 106A, Section 4 Pre-section problem
 */

import acm.program.*;

public class Palindromes extends ConsoleProgram {
	public void run() {
		println(isPalindrome("racecar"));                           // true
		println(isPalindrome("abba"));                              // true
		println(isPalindrome("abcdefgfedcba"));                     // true
		println(isPalindrome("KeItH hEiTk"));                       // true
		println(isPalindrome("q"));                                 // true
		println(isPalindrome(""));                                  // true

		println(isPalindrome("she sells seashells"));               // false
		println(isPalindrome("Java lava"));                         // false
		println(isPalindrome("racejar"));                           // false
		println(isPalindrome("noun"));                              // false
		println(isPalindrome("Able was I ere I sew Elba"));         // false

		// optional: handling spaces and punctuation
		println(isPalindrome("Madam, I'm Adam"));                   // true
		println(isPalindrome("A man, a plan, a canal: Panama!"));   // true
	}
	
	public boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
				return false;
			}
		}
		return true;
	}
	
}
