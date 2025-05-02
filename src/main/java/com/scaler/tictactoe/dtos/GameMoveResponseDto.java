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
}
