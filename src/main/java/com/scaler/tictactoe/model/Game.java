package com.scaler.tictactoe.model;

import com.scaler.tictactoe.strategy.WinningStrategy;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game extends BaseModel{
    private Board board;
    private List<Player> players;
    private int nextPlayerIdx;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> strategies;
    private Player winner;

}
