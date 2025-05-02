package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.GameState;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameMoveResponseDto {
    private Move move;
    private GameState gameState;
    private Player winner;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
