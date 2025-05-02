package com.scaler.tictactoe.dtos;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LogOutRequestDto {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
