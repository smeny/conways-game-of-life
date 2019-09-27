package com.github.smeny.gol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GameOfLifeTest {

    private GameOfLife game;

    @Test
    void aliveCellWithFewerThanTwoLivingNeighboursDies() {
        var initialBoard = new boolean[][]{
                {false, false, true},
                {false, true, false},
                {true, false, false}
        };
        game = new GameOfLife(initialBoard);

        game.nextGen();

        var expected = new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };
        assertArrayEquals(expected, game.getBoard());
    }

    @Test
    void aliveCellWithTwoOrThreeLivingNeighboursLives() {
        var initialBoard = new boolean[][]{
                {false, false, true},
                {true, true, false},
                {true, false, false}
        };
        game = new GameOfLife(initialBoard);

        game.nextGen();

        var expected = new boolean[][]{
                {false, false, false},
                {true, true, false},
                {true, false, false}
        };
        assertArrayEquals(expected, game.getBoard());
    }

    @Test
    void aliveCellWithMoreThanThreeLivingNeighboursDies() {
        var initialBoard = new boolean[][]{
                {true, false, true},
                {true, true, false},
                {true, false, false}
        };
        game = new GameOfLife(initialBoard);

        game.nextGen();

        var expected = new boolean[][]{
                {true, false, false},
                {true, false, false},
                {true, false, false}
        };
        assertArrayEquals(expected, game.getBoard());
    }

}