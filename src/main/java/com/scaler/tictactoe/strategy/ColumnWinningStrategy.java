package com.scaler.tictactoe.strategy;

import com.scaler.tictactoe.model.Board;
import com.scaler.tictactoe.model.Cell;
import com.scaler.tictactoe.model.Move;
import com.scaler.tictactoe.model.Symbol;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ColumnWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Symbol, Integer>> columnMap;

    public ColumnWinningStrategy() {
        columnMap = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        Cell cell = move.getCell();
        int col = cell.getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if (!columnMap.containsKey(col)) {
            columnMap.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> columnSymbolMap = columnMap.get(col);
        columnSymbolMap.put(symbol, columnSymbolMap.getOrDefault(symbol, 0) +1);
        return board.getSize() == columnSymbolMap.get(symbol);
    }
}
