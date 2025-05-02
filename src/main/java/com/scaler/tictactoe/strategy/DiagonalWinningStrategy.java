package com.scaler.tictactoe.strategy;

import com.scaler.tictactoe.model.Board;
import com.scaler.tictactoe.model.Cell;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.model.Symbol;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DiagonalWinningStrategy implements WinningStrategy {
    private Map<Symbol, Integer> mainDiagonalWinningMap;
    private Map<Symbol, Integer> antiDiagonalWinningMap;
    public DiagonalWinningStrategy() {
        this.mainDiagonalWinningMap = new HashMap<>();
        this.antiDiagonalWinningMap = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if((row + col) == board.getSize()-1){
            antiDiagonalWinningMap.put(symbol, antiDiagonalWinningMap.getOrDefault(symbol, 0) + 1);
        }

        if(row == col){
            mainDiagonalWinningMap.put(symbol, mainDiagonalWinningMap.getOrDefault(symbol, 0) + 1);
        }
        return mainDiagonalWinningMap.getOrDefault(symbol, 0) == board.getSize() ||
                antiDiagonalWinningMap.getOrDefault(symbol, 0) == board.getSize();
    }
}
