package com.scaler.tictactoe.model;

import com.scaler.tictactoe.strategy.WinningStrategy;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game extends BaseModel{
    @OneToOne
    private Board board;
    @ManyToMany
    private List<Player> players;
    private int nextPlayerIdx;
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Move> moves;
    @Enumerated(EnumType.STRING)
    private GameState gameState;
    @Transient
    private List<WinningStrategy> strategies;
    @OneToOne
    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerIdx() {
        return nextPlayerIdx;
    }

    public void setNextPlayerIdx(int nextPlayerIdx) {
        this.nextPlayerIdx = nextPlayerIdx;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<WinningStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<WinningStrategy> strategies) {
        this.strategies = strategies;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
