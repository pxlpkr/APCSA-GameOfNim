/*
 * Copyright (c) 2022 Axel Parkkila, Micah Grimaud, Isaac Johnson
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A program that simulates a game of Nim
 *
 * @author      Axel Parkkila
 * @author      Micah Grimaud
 * @author      Isaac Johnson
 */
public class Game {
    /**
     * A scanner that is used to obtain user input.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * A {@code Board} object that stores information about the object heap
     */
    private static Board board;

    /**
     * A list containing the {@code Player} objects that represent game participants <p>
     * Length is > 1
     */
    private static Player[] player;

    public static void main(String[] args) {

        //Create players and prompt for their names
        System.out.print("Enter the number of players: ");
        int numberOfPlayers = 0;
        while (numberOfPlayers < 2) {
            try {
                numberOfPlayers = scanner.nextInt();
                if (numberOfPlayers < 2) {
                    //Check if number is positive
                    System.out.print("Please enter an integer that is greater than zero: ");
                    numberOfPlayers = 0;
                }
            } catch (InputMismatchException e) {
                //Check if it is a valid number
                System.out.print("Please enter an integer: ");
                scanner.next();
            }
        }
        player = new Player[numberOfPlayers];
        int currentPlayerId = (int) (Math.random()*numberOfPlayers);
        scanner.nextLine(); //Scanner is broken, this needs to be here because it skips one for whatever reason
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Enter Player %s name: ", i+1);
            player[i] = new Player(scanner.nextLine());
        }

        //Make board
        board = new Board(numberOfPlayers);

        //Begin game loop
        while (board.getHeapSize() != 0) {
            Player currentPlayer = player[currentPlayerId];
            System.out.printf("%s's turn! There are %s pieces in the pile. How many will you remove? ", player[currentPlayerId].getName(), board.getHeapSize());

            //Get user input and validate it
            int numberToRemove = 0;
            while (numberToRemove < 1) {
                try {
                    numberToRemove = scanner.nextInt();

                    if (numberToRemove > board.getHeapSize() / 2 && numberToRemove != 1) {
                        //Check if input number is less than half of the size of the pile
                        System.out.print("Please enter an integer that is less than half of the size of the pile or is 1: ");
                        numberToRemove = 0;

                    } else if (numberToRemove < 1) {
                        //Check if number is positive
                        System.out.print("Please enter an integer that is greater than zero: ");
                        numberToRemove = 0;

                    }
                } catch (InputMismatchException e) {
                    //Check if it is a valid number
                    System.out.print("Please enter an integer: ");
                    scanner.next();
                }
            }

            board.changeHeapSize(-numberToRemove);

            //Check if the game is over
            if (board.getHeapSize() == 0) {
                //Print and update scores
                System.out.printf("%s loses!\n", currentPlayer.getName());
                player[currentPlayerId].subtractScore();
                for (int i = 0; i < numberOfPlayers; i++) {
                    System.out.printf(" • %s's score: %s\n", player[i].getName(), player[i].getScore());
                }

                //Ask user if it wants to play again
                String playAgainPrompt = "";
                scanner.nextLine(); //Scanner is broken, this needs to be here because it skips one for whatever reason
                while (!playAgainPrompt.equalsIgnoreCase("yes") && !playAgainPrompt.equalsIgnoreCase("no")) {
                    //Ensure input is one of "yes" or "no"
                    System.out.print("Play again? ");
                    playAgainPrompt = scanner.nextLine();
                }

                //Reset the game
                if (playAgainPrompt.equalsIgnoreCase("yes")) {
                    currentPlayerId = (int) (Math.random()*numberOfPlayers);
                    board.initializeHeap(numberOfPlayers);

                } else { //Exit the game
                    return;
                }
            }

            currentPlayerId = (currentPlayerId + 1) % numberOfPlayers;
        }
    }
}