package com.kieran;

import java.util.HashMap;

public class GameLogic {

    private final char[][] gameBoard;
    private final HashMap<Character, BoardPosition> positions;

    public enum Player {
        PLAYER_1, 
        PLAYER_2
    }

    public GameLogic() {

        this.gameBoard = new char[3][3];
        this.positions = new HashMap<>();

        char count = '1';

        for (int i = 0; i < this.gameBoard.length; i++) {
            
            for (int j = 0; j < this.gameBoard.length; j++) {
                
                this.gameBoard[i][j] = count;
                this.positions.put(count, new BoardPosition(i, j));

                count++;
            }
            
        }

    }

    public boolean placeMarker(char c, Player player) {

        BoardPosition position = this.positions.get(c);

        if (position != null) {

            if (player == Player.PLAYER_1) {

                this.gameBoard[position.getRow()][position.getColumn()] = 'X';

                return true;

            } else if (player == Player.PLAYER_2) {

                this.gameBoard[position.getRow()][position.getColumn()] = 'Y';

                return true;

            }

        }

        return false;

    }

    private boolean checkHorizontal() {

        for (char[] chars : gameBoard) {

            if ((chars[0] == chars[1]) && (chars[1] == chars[2])) {

                return true;

            }

        }

        return false;

    }

    private boolean checkVertical() {

        for (int i = 0; i < gameBoard.length; i++) {
            
            if ((this.gameBoard[0][i] == this.gameBoard[1][i]) && (this.gameBoard[1][i] == this.gameBoard[2][i])) {

                return true;

            }

        }

        return false;

    }

    private boolean checkDiagonal() {

        if ((this.gameBoard[0][0] == this.gameBoard[1][1]) && (this.gameBoard[1][1] == this.gameBoard[2][2])) {

            return true;

        }

        return (this.gameBoard[0][2] == this.gameBoard[1][1]) && (this.gameBoard[1][1] == this.gameBoard[2][0]);

    }

    public boolean hasWon() {

        return this.checkHorizontal() || this.checkVertical() || this.checkDiagonal();

    }

    public boolean boardFilled() {

        for (char[] chars : this.gameBoard) {

            for (int j = 0; j < this.gameBoard[0].length; j++) {

                if ((chars[j] != 'X') && (chars[j] != 'Y')) {

                    return false;

                }

            }

        }

        return true;

    }

    public void printGameBoard() {

        System.out.println();
        System.out.format("   %c   |   %c   |   %c   \n", this.gameBoard[0][0], this.gameBoard[0][1], this.gameBoard[0][2]);
        System.out.println("-------|-------|-------");
        System.out.format("   %c   |   %c   |   %c   \n", this.gameBoard[1][0], this.gameBoard[1][1], this.gameBoard[1][2]);
        System.out.println("-------|-------|-------");
        System.out.format("   %c   |   %c   |   %c   \n", this.gameBoard[2][0], this.gameBoard[2][1], this.gameBoard[2][2]);
        System.out.println();

    }

}
