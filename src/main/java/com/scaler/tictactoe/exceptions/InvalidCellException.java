package com.scaler.tictactoe.exceptions;

public class InvalidCellException extends RuntimeException {
    public InvalidCellException(String message) {
        super(message);
    }
}
