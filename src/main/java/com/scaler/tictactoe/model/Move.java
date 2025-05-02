package com.scaler.tictactoe.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "moves")
@Getter
@Setter

public class Move extends BaseModel{
    @OneToOne
    private Cell cell;
    @ManyToOne
    private Player player;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;
    public Move() {

    }

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
