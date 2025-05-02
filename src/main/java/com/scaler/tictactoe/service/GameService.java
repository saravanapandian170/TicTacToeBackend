package com.scaler.tictactoe.service;

import com.scaler.tictactoe.exceptions.GameNotFoundException;
import com.scaler.tictactoe.exceptions.GameOverException;
import com.scaler.tictactoe.model.Game;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.model.Player;

import java.util.List;

public interface GameService {
    Game createGame(List<Player> players);
    Game getGame(long gameId) throws GameNotFoundException;
    Move makeMove(long gameId, int row, int col, Player player) throws GameNotFoundException, GameOverException;
    //void displayGame(Game game);
    void undoMove(long gameId);
}
