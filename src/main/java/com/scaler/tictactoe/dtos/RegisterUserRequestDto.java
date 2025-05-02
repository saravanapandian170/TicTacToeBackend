package com.scaler.tictactoe.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
public class RegisterUserRequestDto {
    @NotEmpty(message = "User name required")
    private String username;
    @NotEmpty(message = "Enter emailId")
    private String email;
    @NotEmpty(message = "Enter Password")
    private String password;
}
