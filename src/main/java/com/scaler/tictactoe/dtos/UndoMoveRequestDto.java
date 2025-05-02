package com.scaler.tictactoe.dtos;

import jakarta.validation.constraints.NotNull;

public class UndoMoveRequestDto {
    @NotNull(message = "Game ID is required")
    private long gameId;
    private ResponseStatus status;
}
