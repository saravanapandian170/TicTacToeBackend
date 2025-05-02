package com.scaler.tictactoe.strategy;

import com.scaler.tictactoe.model.Board;
import com.scaler.tictactoe.model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
