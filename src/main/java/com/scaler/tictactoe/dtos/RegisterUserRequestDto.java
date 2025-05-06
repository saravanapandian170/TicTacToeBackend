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

    public RegisterUserRequestDto() {
    }

    public RegisterUserRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
