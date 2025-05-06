package com.scaler.tictactoe.dtos;

public class PlayerDto {
    private long id;
    private char symbolChar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    public PlayerDto(long id, char symbol) {
        this.id = id;
        this.symbolChar = symbol;
    }
}
