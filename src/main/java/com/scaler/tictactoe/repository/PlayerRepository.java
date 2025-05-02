package com.scaler.tictactoe.repository;

import com.scaler.tictactoe.model.Human;
import com.scaler.tictactoe.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Human, Long> {
    Optional<Human> findByName(String name);
    Optional<Human> findByEmail(String id);
    //Player save(Player player);
}
