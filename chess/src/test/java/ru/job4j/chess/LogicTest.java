package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundException() throws OccupiedCellException,
            FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.B1, Cell.D3);
    }
    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCellException() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.B1);
        BishopBlack bishopBlack = new BishopBlack(Cell.D3);
        logic.add(bb);
        logic.add(bishopBlack);
        logic.move(Cell.B1, Cell.D3);
    }


}