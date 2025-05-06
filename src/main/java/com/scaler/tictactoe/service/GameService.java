package com.scaler.tictactoe.service;

import com.scaler.tictactoe.dtos.PlayerDto;
import com.scaler.tictactoe.exceptions.GameNotFoundException;
import com.scaler.tictactoe.exceptions.GameOverException;
import com.scaler.tictactoe.exceptions.PlayerNotFoundException;
import com.scaler.tictactoe.model.*;

import java.util.List;

public interface GameService {
    Game createGame(List<PlayerDto> playerDtos);
    Game getGame(long gameId) throws GameNotFoundException;
    Move makeMove(long gameId, int row, int col, Player player) throws GameNotFoundException, GameOverException;
    //void displayGame(Game game);
    void undoMove(long gameId);
    List<Player> getPlayerList(List<PlayerDto> playerDtos) throws PlayerNotFoundException;
    Symbol symbol(char symbol);
}
