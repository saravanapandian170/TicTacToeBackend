package com.scaler.tictactoe.controller;

import com.scaler.tictactoe.dtos.*;
import com.scaler.tictactoe.dtos.ResponseStatus;
import com.scaler.tictactoe.model.Game;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.service.GameService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;
    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<CreateGameResponseDto> createGame(@Valid @RequestBody CreateGameRequestDto requestDto) {
        CreateGameResponseDto responseDto = new CreateGameResponseDto();
        try{
            Game game = this.gameService.createGame(requestDto.getPlayerDtos());
            responseDto.setGame(game);
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e){
            log.warn("Game creation failed", e);
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
        //return responseDto;
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GetGameResponseDto> getGame(@PathVariable long gameId) {
        GetGameResponseDto responseDto = new GetGameResponseDto();
        try{
            Game game = this.gameService.getGame(gameId);
            responseDto.setGame(game);
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e){
            log.warn("No game is found with that Id", e);
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
       // return responseDto;
    }

    @PostMapping("/move")
    public ResponseEntity<MoveResponseDto> moveGame(@Valid @RequestBody MoveRequestDto requestDto) {
        MoveResponseDto responseDto = new MoveResponseDto();
        try{
            Move move = this.gameService.makeMove(requestDto.getGameId(), requestDto.getRow(),
                                                    requestDto.getColumn(), requestDto.getPlayer());

            Game game = this.gameService.getGame(requestDto.getGameId());
            responseDto.setMove(move);
            responseDto.setGameState(game.getGameState());
            responseDto.setWinner(game.getWinner());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e){
            log.warn("Move failed", e);
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
        //return responseDto;
    }

    @PostMapping("/undo/{gameId}")
    public ResponseEntity<UndoMoveResponseDto> undoMoveGame(@PathVariable long gameId) {
        UndoMoveResponseDto responseDto = new UndoMoveResponseDto();
        try{
            this.gameService.undoMove(gameId);
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e){
            log.warn("Undo failed", e);
            responseDto.setStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
        //return responseDto;
    }
}
