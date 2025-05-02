package com.scaler.tictactoe.strategy;

import com.scaler.tictactoe.model.Board;
import com.scaler.tictactoe.model.Cell;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.model.Symbol;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RowWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol, Integer>> rowWinningMap;

    public RowWinningStrategy() {
        rowWinningMap = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {

            Cell cell = move.getCell();
            int row = cell.getRow();
            Symbol symbol = cell.getSymbol();

            if(!rowWinningMap.containsKey(row)) {
                rowWinningMap.put(row, new HashMap<>());
            }
            Map<Symbol, Integer> symbolCountMap = rowWinningMap.get(row);
            symbolCountMap.put(symbol, symbolCountMap.getOrDefault(symbol, 0) + 1);

            return symbolCountMap.get(symbol) == board.getSize();

    }
}
