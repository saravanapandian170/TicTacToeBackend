package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import lombok.*;


@Entity(name = "bots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
