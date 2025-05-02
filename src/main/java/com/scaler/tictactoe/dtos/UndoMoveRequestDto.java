package com.scaler.tictactoe.dtos;

import jakarta.validation.constraints.NotNull;

public class UndoMoveRequestDto {
    @NotNull(message = "Game ID is required")
    private long gameId;
    private ResponseStatus status;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
