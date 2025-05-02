package com.scaler.tictactoe.dtos;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class DeRegisterRequestDto {
    private String email;
    private String password;

}
