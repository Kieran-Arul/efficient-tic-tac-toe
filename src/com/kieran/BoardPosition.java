package com.kieran;

public class BoardPosition {

    private final int row;
    private final int column;

    public BoardPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
    
}
