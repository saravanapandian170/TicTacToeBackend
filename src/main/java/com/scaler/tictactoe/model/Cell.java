package com.scaler.tictactoe.model;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor

public class Cell extends BaseModel{
    private int row;
    private int col;
    private CellState cellState;
    private Player player;
    private Symbol symbol;

    public Cell(){

    }
    public Cell(int row, int col, Symbol symbol, Player player) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
        this.player = player;
        this.cellState = CellState.EMPTY;
    }
}
