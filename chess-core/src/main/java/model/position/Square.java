package model.position;

import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Square {
    private final Row row;
    private final Column column;

    public Square(Column column, Row row) {
        Validate.notNull(row);
        Validate.notNull(column);

        this.row = row;
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

    public boolean isInHorse(Square square) {
        int columnDifference = Math.abs(this.column.differenceBetween(square.column));
        int rowDifference = Math.abs(this.row.differenceBetween(square.row));
        return (columnDifference == 2 && rowDifference == 1) ||
                (columnDifference == 1 && rowDifference == 2);
    }

    public boolean isInRow(Square square) {
        return this.row == square.row;
    }

    public boolean isInRowOneSquare(Square square) {
        return this.isInRow(square) && Math.abs(this.column.differenceBetween(square.column)) == 1;
    }

    public boolean isInColumn(Square square) {
        return this.column == square.column;
    }

    public boolean isInColumnOneSquare(Square square) {
        return this.isInColumn(square) && Math.abs(this.row.differenceBetween(square.row)) == 1;
    }

    public boolean isInDiagonal(Square square) {
        int columnDifference = Math.abs(this.column.differenceBetween(square.column));
        int rowDifference = Math.abs(this.row.differenceBetween(square.row));
        return columnDifference == rowDifference;
    }

    public boolean isInDiagonalOneSquare(Square square) {
        return this.isInDiagonal(square) && Math.abs(this.column.differenceBetween(square.column)) == 1
                && Math.abs(this.row.differenceBetween(square.row)) == 1;
    }

    public boolean isUpInDiagonalOneSquare(Square square) {
        return this.isInDiagonal(square) && Math.abs(this.column.differenceBetween(square.column)) == 1
                && this.row.differenceBetween(square.row) == -1;
    }

    public boolean isDownInDiagonalOneSquare(Square square) {
        return this.isInDiagonal(square) && Math.abs(this.column.differenceBetween(square.column)) == 1
                && this.row.differenceBetween(square.row) == 1;
    }


    public boolean isUpOneSquare(Square square) {
        return this.isInColumn(square) && this.row.differenceBetween(square.row) == -1;
    }

    public boolean isUpTwoSquare(Square square) {
        return this.isInColumn(square) && this.row.differenceBetween(square.row) == -2;
    }

    public boolean isDownOneSquare(Square square) {
        return this.isInColumn(square) && this.row.differenceBetween(square.row) == 1;
    }

    public boolean isDownTwoSquare(Square square) {
        return this.isInColumn(square) && this.row.differenceBetween(square.row) == 2;
    }


    public boolean isInInitialWhitePawn() {
        return this.row == Row.TWO;
    }

    public boolean isInInitialBlackPawn() {
        return this.row == Row.SEVEN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return row == square.row && column == square.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Square{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}
