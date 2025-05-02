package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.Game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetGameResponseDto {
    private Game game;
    private ResponseStatus status;
}
