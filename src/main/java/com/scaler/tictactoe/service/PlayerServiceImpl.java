package com.scaler.tictactoe.service;

import com.scaler.tictactoe.exceptions.DuplicatePlayerException;
import com.scaler.tictactoe.exceptions.PlayerNotFoundException;
import com.scaler.tictactoe.exceptions.UnAuthorizedUserException;
import com.scaler.tictactoe.model.Human;
import com.scaler.tictactoe.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Human registerPlayer(String playerName, String email, String password) throws DuplicatePlayerException {
        Optional<Human> playerOptional = this.playerRepository.findByEmail(email);
        if(playerOptional.isPresent()) {
            throw new DuplicatePlayerException("User already exists");
        }
        Human player = new Human();
        player.setName(playerName);
        player.setEmail(email);
        player.setPassword(passwordEncoder.encode(password));
        return this.playerRepository.save(player);
    }

    @Override
    public void deRegisterPlayer(String email, String password) throws PlayerNotFoundException, UnAuthorizedUserException {
        Human player1 = this.playerRepository.findByEmail(email).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        if(!passwordEncoder.matches(password, player1.getPassword())) {
            throw new UnAuthorizedUserException("Password does not match");
        }
        this.playerRepository.delete(player1);
    }

   @Override
    public void loginPlayer(String email, String rawPassword) throws PlayerNotFoundException, UnAuthorizedUserException {
        Human player = this.playerRepository.findByEmail(email).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        if(!passwordEncoder.matches(rawPassword, player.getPassword())) {
            throw new UnAuthorizedUserException("Password does not match");
        }
        player.setLoggedIn(true);
        this.playerRepository.save(player);
       log.info("Login successful for player: {}", player.getName());
    }

    @Override
    public void logoutPlayer(String email) throws PlayerNotFoundException {
        Human player = this.playerRepository.findByEmail(email).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        player.setLoggedIn(false);
        this.playerRepository.save(player);
        log.info("Logged out");
    }
}
