package com.scaler.tictactoe.repository;

import com.scaler.tictactoe.model.GamePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, Long> {
}
