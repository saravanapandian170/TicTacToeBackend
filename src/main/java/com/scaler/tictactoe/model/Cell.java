package com.scaler.tictactoe.model;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

@Data
@Entity(name = "cells")
@Getter
@Setter
@AllArgsConstructor

public class Cell extends BaseModel{
    private int row;
    private int col;
    private CellState cellState;
    @ManyToOne
    private Player player;
    @ManyToOne
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
