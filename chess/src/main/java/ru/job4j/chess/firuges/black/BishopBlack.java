package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int x = position.getX();
        int y = position.getY();
        int size = Math.abs(x - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - x) / size;
        int deltaY =(dest.getY() - y) / size;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x = x + deltaX, y= y+ deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (dest.getX() - position.getX()) != 0 &&
                (dest.getY() - position.getY()) != 0;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
