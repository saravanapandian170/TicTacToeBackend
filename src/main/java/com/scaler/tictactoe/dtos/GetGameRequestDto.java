package com.scaler.tictactoe.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetGameRequestDto {
    @NotNull(message = "Game ID is required")
    private long gameId;
}
