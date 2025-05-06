package com.scaler.tictactoe.repository;

import com.scaler.tictactoe.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    //Game findGameById(Long id);
    //Game findGameByPlayerId(Long id);
     @Query("SELECT g FROM games g JOIN g.players p WHERE p.id = :playerId")
    List<Game> findGamesByPlayerId(@Param("playerId") Long playerId);
    Game save(Game game);
}
