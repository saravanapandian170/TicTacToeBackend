package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Move extends BaseModel{
    private Cell cell;
    private Player player;
}
