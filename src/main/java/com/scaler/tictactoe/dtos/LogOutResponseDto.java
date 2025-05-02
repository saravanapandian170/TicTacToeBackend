package com.scaler.tictactoe.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class LogOutResponseDto {
    private ResponseStatus status;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
