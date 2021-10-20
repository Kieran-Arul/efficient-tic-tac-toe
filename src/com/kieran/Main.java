package com.kieran;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GameLogic GAME = new GameLogic();

    public static void main(String[] args) {

        GAME.printGameBoard();
        char marker;
        
        while(true) {

            System.out.println("Player 1's Turn");

            boolean valid = false;

            while (!valid) {

                System.out.println("Enter the number that corresponds to where you want to put your marker: ");

                marker = scanner.nextLine().charAt(0);

                if (GAME.placeMarker(marker, GameLogic.Player.PLAYER_1)) {
                    
                    valid = true;

                } else {

                    System.out.println("Please enter a valid number");

                }

            }

            GAME.printGameBoard();

            if (GAME.hasWon()) {
                
                System.out.println("Player 1 has won");
                break;

            }

            if (GAME.boardFilled()) {
                
                System.out.println("Game is a tie");
                break;

            }

            System.out.println("Player 2's Turn");

            valid = false;

            while (!valid) {

                System.out.println("Enter the number that corresponds to where you want to put your marker: ");

                marker = scanner.nextLine().charAt(0);

                if (GAME.placeMarker(marker, GameLogic.Player.PLAYER_2)) {
                    
                    valid = true;

                } else {

                    System.out.println("Please enter a valid number");

                }

            }

            GAME.printGameBoard();

            if (GAME.hasWon()) {
                
                System.out.println("Player 2 has won");
                break;

            }

            if (GAME.boardFilled()) {
                
                System.out.println("Game is a tie");
                break;

            }

        }

    }

}
