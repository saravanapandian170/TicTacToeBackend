package com.scaler.tictactoe.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Symbol extends BaseModel{
    private char symbol;
    public Symbol() {}
    public Symbol(char symbol) {
        this.symbol = symbol;
    }
}
