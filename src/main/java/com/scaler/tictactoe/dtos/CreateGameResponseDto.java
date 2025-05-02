package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.Game;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateGameResponseDto {
    private Game game;
    private ResponseStatus status;
}
