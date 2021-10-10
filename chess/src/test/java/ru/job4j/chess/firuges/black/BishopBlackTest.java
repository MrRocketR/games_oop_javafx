package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionD8() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.D8);
        boolean rsl = Cell.D8 == bishopBlack1.position();
        Assert.assertTrue(rsl);
    }

    @Test
    public void whenCopyE7() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.D8);
        bishopBlack1.copy(Cell.E7);
        boolean rsl = Cell.E7 == bishopBlack1.position();
    }

    @Test
    public void whenC1G5() {
        Cell[] testCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C1);
        Cell[] actualCells = bishopBlack1.way(Cell.G5);
        Assert.assertArrayEquals(actualCells, testCells);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenC1C5IsWrongWay() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C1);
        bishopBlack1.way(Cell.C5);

    }

}