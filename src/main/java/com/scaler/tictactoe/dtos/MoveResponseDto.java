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
}
