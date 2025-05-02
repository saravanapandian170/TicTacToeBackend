package com.scaler.tictactoe.service;

import com.scaler.tictactoe.exceptions.DuplicatePlayerException;
import com.scaler.tictactoe.exceptions.PlayerNotFoundException;
import com.scaler.tictactoe.exceptions.UnAuthorizedUserException;
import com.scaler.tictactoe.model.Human;

public interface PlayerService {
    Human registerPlayer(String playerName, String email, String password) throws DuplicatePlayerException;
    void deRegisterPlayer(String email, String password) throws PlayerNotFoundException, UnAuthorizedUserException;
    void loginPlayer(String email, String password) throws PlayerNotFoundException, UnAuthorizedUserException;
    void logoutPlayer(String playerName) throws PlayerNotFoundException;
}
