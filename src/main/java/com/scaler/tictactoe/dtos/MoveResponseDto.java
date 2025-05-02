package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.GameState;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.model.Player;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MoveResponseDto {
    private Move move;
    private ResponseStatus status;
    private GameState gameState;
    private Player winner;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
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
