package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Entity(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Player extends BaseModel{
    private String name;
    @OneToOne
    private Symbol symbol;
    @Enumerated(EnumType.STRING)
    private PlayerType playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
