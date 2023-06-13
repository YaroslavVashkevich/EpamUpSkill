package com.epam.rd.autocode.concurrenttictactoe;

public class PlayerImpl implements Player {
    final char mark;
    final TicTacToe board;
    PlayerStrategy strategy;

    public PlayerImpl(char mark, TicTacToe board, PlayerStrategy strategy) {
        this.mark = mark;
        this.board = board;
        this.strategy = strategy;
    }

    private void takeTurn() {
        if (anyPlayerWin()) {
            board.isGameOver().set(true);
            return;
        }
        Move move = strategy.computeMove(mark, board);
        board.setMark(move.row, move.column, mark);
    }

    @Override
    public void run() {
        while (!board.isGameOver().get()) {
            if (board.lastMark() != mark) {
                takeTurn();
            }
        }

    }


    private boolean anyPlayerWin() {
        return isDiagonalWin() || isVerticalWin() || isHorizontalWin();
    }

    private boolean isDiagonalWin() {
        for (int i = 0; i < board.table().length; i++) {
            if (board.table()[i][i] != board.lastMark()) {
                break;
            } else if (i == board.table().length - 1) {
                return true;
            }
        }
        for (int i = 0; i < board.table().length; i++) {
            if (board.table()[i][board.table().length - 1 - i] != board.lastMark()) {
                break;
            } else if (i == board.table().length - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalWin() {
        for (int i = 0; i < board.table().length; i++) {
            for (int j = 0; j < board.table()[i].length; j++) {
                if (board.table()[j][i] != board.lastMark()) {
                    break;
                } else if (j == board.table()[i].length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isHorizontalWin() {
        for (char[] chars : board.table()) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != board.lastMark()) {
                    break;
                } else if (j == chars.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}