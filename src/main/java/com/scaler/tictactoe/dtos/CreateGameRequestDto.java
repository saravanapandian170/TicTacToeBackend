package com.scaler.tictactoe.dtos;

import com.scaler.tictactoe.model.Player;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateGameRequestDto {
    @NotNull(message = "Players list cannot be null")
    @NotEmpty(message = "There must be at least one player")
    private List<Player> players;
}
