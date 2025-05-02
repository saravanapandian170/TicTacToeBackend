package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.Player;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class MoveRequestDto {
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @NotNull(message = "Game ID is required")
    private int gameId;
    @NotNull(message = "Player must not be null")
    private int row;
    @Min(value = 0, message = "Row must be >= 0")
    private int column;
    @Min(value = 0, message = "Column must be >= 0")
    private Player player;
}
