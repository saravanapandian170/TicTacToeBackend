package com.scaler.tictactoe.dtos;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class DeRegisterRequestDto {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
