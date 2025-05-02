package com.scaler.tictactoe.exceptions;

public class UnAuthorizedPlayerException extends RuntimeException {
    public UnAuthorizedPlayerException(String message) {
        super(message);
    }
}
