package com.scaler.tictactoe.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class LogOutResponseDto {
    private ResponseStatus status;
}
