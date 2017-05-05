// This is a .h file you will edit and turn in.
// We have provided a skeleton for you,
// but you must finish it as described in the spec.
// Also remove these comments here and add your own.
// TODO: remove this comment header

#ifndef _boggle_h
#define _boggle_h

#include <iostream>
#include <string>
#include "lexicon.h"
#include "grid.h"
using namespace std;

class Boggle {
public:
    Boggle(Lexicon& dictionary, string boardText = "");
    char getLetter(int row, int col);
    bool checkWord(string word);
    bool humanWordSearch(string word);
    Set<string> computerWordSearch();
    int getScoreHuman();
    int getScoreComputer();
    string getHumanWords();
    int getNumHumanWords();
    int getHumanScore();
    int getComputerScore();


    // TODO: add any other member functions/variables necessary
    friend ostream& operator<<(ostream& out, Boggle& boggle);

private:
    bool findHumanWord(string word, int row, int col);
    void findComputerWords(Set<string>& result);
    bool findWordsFromBoardIndex(Set<string>& result, string prefix, int row, int col);
    Grid<int> availableSpaces(int row, int col);
    Grid<char> boardGrid;
    Grid<int> highlightedLetters;
    int humanScore, computerScore;
    Lexicon dict;
    Set<string> humanWords;
    string prefixCheck;
};

#endif // _boggle_h
