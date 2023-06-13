package com.epam.rd.autocode.concurrenttictactoe;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public interface TicTacToe {

    /**
     * Sets a mark in cell with specified coordinates.
     * @param x - x coordinate.
     * @param y - y coordinate.
     * @param mark - mark to set.
     */
    void setMark(int x, int y, char mark);

    /**
     * Returns a COPY of current table with marks.
     * Note, edit of that copy should not affect the source TicTacToe object.
     * @return a copy of current table.
     */
    char[][] table();

    /**
     * Returns last mark that was set in a table.
     * @return last mark that was set in a table.
     */
    char lastMark();

    AtomicBoolean isGameOver();

    static TicTacToe buildGame() {
        return new TicTacToeImpl();
    }
}
