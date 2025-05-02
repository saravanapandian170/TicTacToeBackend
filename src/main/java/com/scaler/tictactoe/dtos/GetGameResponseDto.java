package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.Game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetGameResponseDto {
    private Game game;
    private ResponseStatus status;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
