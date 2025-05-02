package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Player extends BaseModel{
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
}
