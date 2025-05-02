package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;

@Data
@Entity(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseModel{
    @Transient
    private Cell[][] board;
    private int size;

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
