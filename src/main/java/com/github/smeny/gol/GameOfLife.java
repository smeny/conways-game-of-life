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
        boolean[][] nextGen = new boolean[board.length][board.length];
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                nextGen[i][j] = determineCellLiveliness(i , j);
            }
        }
        board = nextGen;
    }

    private boolean determineCellLiveliness(int x, int y) {
        int neighbourCount = countCellNeighbours(x, y);
        return isCellAlive(x, y) && neighbourCount >= 2;
    }

    private int countCellNeighbours(int x, int y) {
        int count = 0;
        for (int neighbourY = y - 1; neighbourY <= y + 1; neighbourY++) {
            for (int neighbourX = x - 1; neighbourX <= x + 1; neighbourX++) {

                if (neighbourX == x && neighbourY == y) {
                    continue;
                }
                if (isCellInsideBoard(neighbourX, neighbourY) && isCellAlive(neighbourX, neighbourY)) {
                    count++;
                }

            }
        }

        return count;
    }

    private boolean isCellInsideBoard(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board.length;
    }

    private boolean isCellAlive(int x, int y) {
        return board[x][y];
    }
}
