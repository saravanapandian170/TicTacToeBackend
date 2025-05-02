package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayer extends BaseModel{
    @ManyToOne
    private Player player;
    @ManyToOne
    private Game game;

    private int score;
    private boolean isWinner;
}
