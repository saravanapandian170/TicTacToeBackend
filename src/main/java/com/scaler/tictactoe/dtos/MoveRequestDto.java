package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.Player;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class MoveRequestDto {
    @NotNull(message = "Game ID is required")
    private int gameId;
    @NotNull(message = "Player must not be null")
    private int row;
    @Min(value = 0, message = "Row must be >= 0")
    private int column;
    @Min(value = 0, message = "Column must be >= 0")
    private Player player;
}
