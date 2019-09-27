package com.github.smeny.gol;

class GameOfLife {
    private boolean[][] board;

    public GameOfLife(boolean[][] board) {
        this.board = board;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void nextGen() {
        var nextGen = new boolean[board.length][board.length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                nextGen[row][column] = determineCellLiveliness(row, column);
            }
        }
        board = nextGen;
    }

    private boolean determineCellLiveliness(int row, int column) {
        int neighbourCount = countCellNeighbours(row, column);
        return (isCellAlive(row, column) && (neighbourCount == 2 || neighbourCount == 3)) ||
                (!isCellAlive(row, column) && neighbourCount == 3) ;
    }

    private int countCellNeighbours(int row, int column) {
        int count = 0;
        for (int neighbourRow = row - 1; neighbourRow <= row + 1; neighbourRow++) {
            for (int neighbourColumn = column - 1; neighbourColumn <= column + 1; neighbourColumn++) {

                if (neighbourRow == row && neighbourColumn == column) {
                    continue;
                }
                if (isCellInsideBoard(neighbourRow, neighbourColumn) && isCellAlive(neighbourRow, neighbourColumn)) {
                    count++;
                }

            }
        }

        return count;
    }

    private boolean isCellInsideBoard(int row, int column) {
        return row >= 0 && column >= 0 && row < board.length && column < board[row].length;
    }

    private boolean isCellAlive(int row, int column) {
        return board[row][column];
    }
}
