package com.epam.rd.autocode.concurrenttictactoe;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicTacToeImpl implements TicTacToe {
    private final char[][] table;
    private char lastMark = 'O';
    private final AtomicBoolean isGameOver;
    private final Lock lock = new ReentrantLock();

    public TicTacToeImpl() {
        table = new char[3][3];
        isGameOver = new AtomicBoolean(false);
        for (char[] chars : table) {
            Arrays.fill(chars, ' ');
        }
    }

    public AtomicBoolean isGameOver() {
        return isGameOver;
    }


    @Override
    public void setMark(int x, int y, char mark) {
        lock.lock();
        if (isGameOver.get()){
            return;
        }
        if (table[x][y] == ' ') {
            table[x][y] = mark;
            lastMark = mark;
            lock.unlock();
        } else throw new IllegalArgumentException();
    }

    @Override
    public char[][] table() {
        return deepCopy(table);
    }

    private char[][] deepCopy(char[][] table) {
        final char[][] result = new char[table.length][];
        for (int i = 0; i < table.length; i++) {
            result[i] = Arrays.copyOf(table[i], table[i].length);
        }
        return result;
    }

    @Override
    public char lastMark() {
        return lastMark;
    }
}
