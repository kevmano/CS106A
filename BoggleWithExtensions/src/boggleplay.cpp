// This is a .cpp file you will edit and turn in.
// We have provided a skeleton for you,
// but you must finish it as described in the spec.
// Also remove these comments here and add your own.
// TODO: remove this comment header

#include "lexicon.h"
#include "Boggle.h"
#include "bogglegui.h"
#include "simpio.h"
#include "console.h"
#include <cctype>

Boggle setUpBoard(Lexicon &dictionary);
bool isValidUserBoard(string &userBoardText);
void humanTurn(Boggle &board);
void computerTurn(Boggle &board);
void printResultOfGame(Boggle &board);
void printHumanStatus(Boggle &board);
void printHumanWordMessage(bool validWord, string humanWord);
void printMessageToConsoleAndGUI(string message);

void playOneGame(Lexicon& dictionary) {
    BoggleGUI::initialize(4,4);
    BoggleGUI::setAnimationDelay(100);
    Boggle board = setUpBoard(dictionary);
    clearConsole();
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            BoggleGUI::labelCube(i, j, board.getLetter(i, j), false);
        }
    }
    cout << "It's your turn!" << endl;
    BoggleGUI::setStatusMessage("It's your turn!");
    humanTurn(board);
    cout << endl << "It's my turn!" << endl;
    BoggleGUI::setStatusMessage("It's my turn!");
    computerTurn(board);
    printResultOfGame(board);
}

Boggle setUpBoard(Lexicon& dictionary) {
    string userBoardText = "";
    if (!getYesOrNo("Do you want to generate a random board? ")) {
        while(!isValidUserBoard(userBoardText)) {
            cout << "That is not a valid 16-letter board string. Try again." << endl;
        }
    }
    return Boggle(dictionary, userBoardText);
}

bool isValidUserBoard(string& userBoardText) {
    userBoardText = getLine("Type the 16 letters to appear on the board: ");
    if (userBoardText.length() != 16) return false;
    userBoardText = toUpperCase(userBoardText);
    for (int i = 0; i < userBoardText.size(); i++) {
        if (!isalpha(userBoardText[i])) return false;
    }
    return true;
}

void humanTurn(Boggle& board) {
    string humanWord;
    bool validWord;
    while (true) {
        cout << board << endl;
        printHumanStatus(board);
        humanWord = getLine("Type a word (or Enter to stop): ");
        if (humanWord.empty()) break;
        humanWord = toLowerCase(humanWord);
        validWord = board.humanWordSearch(humanWord);
        printHumanWordMessage(validWord, humanWord);
        clearConsole();
    }
}

void computerTurn(Boggle& board) {
    Set<string> computerWords = board.computerWordSearch();
    cout << "My words (" << computerWords.size() << "): " << computerWords << endl;
    cout << "My score: " << board.getScoreComputer() << endl;
    for (string word:computerWords) {
        BoggleGUI::recordWord(word, BoggleGUI::COMPUTER);
    }
    BoggleGUI::setScore(board.getScoreComputer(), BoggleGUI::COMPUTER);
}

void printResultOfGame(Boggle& board) {
    string message;
    int scoreDiff = board.getScoreComputer() - board.getScoreHuman();
    if (scoreDiff > 0) {
        message = "Ha ha ha, I destroyed you. Better luck next time, puny human!";
    } else if (scoreDiff <= 0) {
        message = "Congratulations, you beat me! I'll get you next time!";
    }
    printMessageToConsoleAndGUI(message);
}

void printHumanStatus(Boggle& board) {
    cout << "Your words (" << board.getNumHumanWords() << "): " << board.getHumanWords() << endl;
    cout << "Your score: " << board.getHumanScore() << endl;
    BoggleGUI::setScore(board.getHumanScore(), BoggleGUI::HUMAN);
}

void printHumanWordMessage(bool validWord, string humanWord) {
    string message;
    if (validWord) {
        message = "You found a new word! \"" + humanWord + "\"";
        BoggleGUI::recordWord(humanWord, BoggleGUI::HUMAN);
    } else {
        message = "You must enter an unfound 4+ letter word from the dictionary.";
    }
    printMessageToConsoleAndGUI(message);
}

void printMessageToConsoleAndGUI(string message) {
    cout << message << endl;
    BoggleGUI::setStatusMessage(message);

}
