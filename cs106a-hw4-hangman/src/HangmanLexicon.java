/*
 * Name: Kevin Manouchehri	Section: Thaminda Edirisooriya Thursday 10:00
 * This creates a class called HangmanLexicon that selects a random word from file containing a large lexicon of words that is read. The lexicon of words
 * are stored in an ArrayList, where when the main Hangman program calls this class, one word is selected to be the secret word for that individual game.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	private ArrayList <String> wordChoices;
	
	public HangmanLexicon() {
		wordChoices = new ArrayList <String> ();
		Scanner newLexicon;
		try {
			newLexicon = new Scanner(new File("res/lexicon-large.txt"));
			while(newLexicon.hasNextLine()) {	// Each word is added to the array.
				String lexicon = newLexicon.nextLine();
				wordChoices.add(lexicon);
			}
		} catch (FileNotFoundException fnfe){
			throw new ErrorException(fnfe);
		}
	}
	
	/*
	 * This returns as a string the random word selected from the lexicon to be
	 * used in the Hangman game
	 */
	public String getRandomWord() {
		return getRandomWordFromLexicon();
	}
	
	/*
	 * This obtains and returns as a string a random word from the ArrayList of
	 * choices.
	 */
	public String getRandomWordFromLexicon() {
		RandomGenerator randy = RandomGenerator.getInstance();
		int randomNumber = randy.nextInt(1, wordChoices.size());
		return wordChoices.get(randomNumber);
	}
}
