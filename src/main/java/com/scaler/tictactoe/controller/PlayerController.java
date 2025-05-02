package com.scaler.tictactoe.controller;

import com.scaler.tictactoe.dtos.*;
import com.scaler.tictactoe.dtos.ResponseStatus;
import com.scaler.tictactoe.model.Human;
import com.scaler.tictactoe.service.GameServiceImpl;
import com.scaler.tictactoe.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;
    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> registerUser(@Valid @RequestBody RegisterUserRequestDto requestDto) {
        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        try{
            Human player = this.playerService.registerPlayer(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUsername(player.getName());
            responseDto.setUserId(player.getId());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.warn("User creation failed", e);
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<DeRegisterResponseDto> deleteUser(@RequestBody DeRegisterRequestDto requestDto) {
        DeRegisterResponseDto responseDto = new DeRegisterResponseDto();
        try {
            playerService.deRegisterPlayer(requestDto.getEmail(), requestDto.getPassword());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) {
        LoginResponseDto responseDto = new LoginResponseDto();
        try{
            this.playerService.loginPlayer(requestDto.getEmail(), requestDto.getPassword());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e){
            log.warn("Login failed", e);
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }

    }

    @PostMapping("/logout")
    public ResponseEntity<LogOutResponseDto> logout(@RequestBody LogOutRequestDto requestDto){
        LogOutResponseDto responseDto = new LogOutResponseDto();
        try{
            this.playerService.logoutPlayer(requestDto.getEmail());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e){
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }
}
