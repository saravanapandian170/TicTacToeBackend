package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
}
