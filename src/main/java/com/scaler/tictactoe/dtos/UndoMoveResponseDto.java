package com.scaler.tictactoe.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UndoMoveResponseDto {
    private ResponseStatus status;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
