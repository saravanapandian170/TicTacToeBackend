package com.scaler.tictactoe.repository;

import com.scaler.tictactoe.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findGameById(Long id);
    Game findGameByPlayerId(Long id);
    List<Game> findGamesByPlayerId(Long id);
    Game save(Game game);
}
