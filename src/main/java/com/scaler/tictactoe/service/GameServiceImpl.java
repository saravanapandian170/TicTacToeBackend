package com.scaler.tictactoe.service;

import com.scaler.tictactoe.dtos.PlayerDto;
import com.scaler.tictactoe.exceptions.*;
import com.scaler.tictactoe.model.*;
import com.scaler.tictactoe.repository.GameRepository;
import com.scaler.tictactoe.repository.PlayerRepository;
import com.scaler.tictactoe.repository.SymbolRepository;
import com.scaler.tictactoe.strategy.WinningStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;
    private PlayerRepository playerRepository;
    private SymbolRepository symbolRepository;
    private List<WinningStrategy> strategies;
    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);
    @Autowired
    public GameServiceImpl(GameRepository gameRepository, PlayerRepository playerRepository,
                           SymbolRepository symbolRepository, List<WinningStrategy> strategies) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.symbolRepository = symbolRepository;
        this.strategies = strategies;
    }

    @Override
    public Game createGame(List<PlayerDto> playerDtos) throws PlayerNotFoundException{
        if (playerDtos == null || playerDtos.size() < 2) {
            throw new IllegalArgumentException("At least 2 players required to create a game.");
        }
        Board newBoard = createBoard(playerDtos.size() + 1);
        List<Player> players = getPlayerList(playerDtos);

        int nextPlayerIdx = 0;
        Game newGame = new Game();
        newGame.setGameState(GameState.IN_PROGRESS);
        newGame.setBoard(newBoard);
        newGame.setPlayers(players);
        newGame.setNextPlayerIdx(nextPlayerIdx);
        newGame.setStrategies(strategies);
        return this.gameRepository.save(newGame);
    }

    @Override
    public Game getGame(long gameId) throws GameNotFoundException {
        Game game = this.gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Game not found"));
        return game;
    }

    @Override
    public Move makeMove(long gameId, int row, int col, Player player) throws GameNotFoundException, GameOverException {
        Game currGame = this.gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Game not found"));
        if (!currGame.getGameState().equals(GameState.IN_PROGRESS)) {
            throw new GameOverException("Game is already over");
        }

        List<Move> moves = currGame.getMoves();
        Move move = null;
        try {
            int nextIdx = currGame.getNextPlayerIdx();
            Player currPlayer = currGame.getPlayers().get(nextIdx);
            if (currPlayer.getId() != (player.getId())) {
                throw new UnAuthorizedPlayerException("This is not your turn");
            }

            Cell currCell = new Cell(row, col, currPlayer.getSymbol(), currPlayer);
            if (!isValidCell(row, col, currGame.getBoard())) throw new InvalidCellException("Invalid cell");
            move = new Move(currCell, currPlayer);
            Cell cellAtBoard = currGame.getBoard().getBoard()[row][col];
            if (cellAtBoard.getSymbol().getSymbol() != '-') {
                throw new InvalidCellException("The cell is already occupied");
            }
            Cell boardCell = currGame.getBoard().getBoard()[row][col];
            boardCell.setSymbol(currPlayer.getSymbol());
            boardCell.setPlayer(currPlayer);
            moves.add(move);
            log.info("Player {} made a move at ({}, {}) in Game {}", currPlayer.getId(), row, col, gameId);

            for (WinningStrategy strategy : strategies) {
                if (strategy.checkWinner(currGame.getBoard(), move)) {
                    currGame.setWinner(currPlayer);
                    currGame.setGameState(GameState.SUCCESS);
                    log.info("Player {} won the game {}", currPlayer.getId(), gameId);
                }
            }
            if(currGame.getGameState() == GameState.IN_PROGRESS) {
                nextIdx = (currGame.getNextPlayerIdx() + 1) % currGame.getPlayers().size();
                currGame.setNextPlayerIdx(nextIdx);
            }
            if (isBoardFull(moves, currGame.getBoard())) {
                currGame.setGameState(GameState.DRAW);
                log.info("Game {} ended in a draw", gameId);
            }
        } catch (InvalidCellException | InvalidMoveException e) {
            log.warn("Invalid move attempted", e);
            throw  e;
             }
        //displayGame(currGame);
        this.gameRepository.save(currGame);
        return move;
    }

    @Override
    public void undoMove(long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game not found"));

        List<Move> moves = game.getMoves();
        if (moves.isEmpty()) throw new RuntimeException("No moves to undo");

        Move lastMove = moves.remove(moves.size() - 1);
        Cell cell = lastMove.getCell();
        int row = cell.getRow();
        int col = cell.getCol();

        game.getBoard().getBoard()[row][col].setSymbol(new Symbol('-'));
        int newIndex = (game.getNextPlayerIdx() - 1 + game.getPlayers().size()) % game.getPlayers().size();
        game.setNextPlayerIdx(newIndex);
        game.setGameState(GameState.IN_PROGRESS);

        this.gameRepository.save(game);
    }

    @Override
    public List<Player> getPlayerList(List<PlayerDto> playerDtos) throws PlayerNotFoundException {
        List<Player> list = new ArrayList<>();
        for(PlayerDto playerDto : playerDtos) {
            Human player = this.playerRepository.findById(playerDto.getId()).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
            player.setSymbol(symbol(playerDto.getSymbolChar()));
            list.add(player);
        }
        return list;
    }

    @Override
    public Symbol symbol(char symbolChar) {
        return this.symbolRepository.findBySymbol(symbolChar)
                .orElseGet(() -> this.symbolRepository.save(new Symbol(symbolChar)));
    }

    private void populateBoard(Board gameBoard) {
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {

                gameBoard.getBoard()[i][j] = new Cell(i, j, new Symbol('-') , null);
            }
        }
    }
    private Board createBoard(int size) {
        Board gameBoard = new Board();
        gameBoard.setSize(size);
        gameBoard.setBoard(new Cell[size][size]);
        populateBoard(gameBoard);
        return gameBoard;
    }
    private boolean isValidCell(int row, int col, Board gameBoard) {
        return row >= 0 && row < gameBoard.getSize()
                && col >= 0 && col < gameBoard.getSize();
    }
    private boolean isBoardFull(List<Move> moves, Board gameBoard) {
        return moves.size() == gameBoard.getSize() * gameBoard.getSize();
    }
}
