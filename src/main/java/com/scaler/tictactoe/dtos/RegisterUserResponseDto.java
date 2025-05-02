package com.scaler.tictactoe.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegisterUserResponseDto {
    private long userId;
    private String username;
    private ResponseStatus status;
}
