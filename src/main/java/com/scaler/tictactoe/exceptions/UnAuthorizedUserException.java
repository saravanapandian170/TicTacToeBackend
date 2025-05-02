package com.scaler.tictactoe.exceptions;

public class UnAuthorizedUserException extends RuntimeException {
    public UnAuthorizedUserException(String message) {
        super(message);
    }
}
