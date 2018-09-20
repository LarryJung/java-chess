package pieces.coordinate;

import pieces.Piece;
import pieces.unitInfo.PawnInfo;
import pieces.unitInfo.UnitInfo;

import java.util.Objects;

public class Coordinate {

    private Line row;
    private Line column;

    public Coordinate(int row, char col) {
        this.row = new Line(row);
        this.column = new Line(col);
    }

    public Coordinate(int row, int col) {
        this.row = new Line(row);
        this.column = new Line(col);
    }

    public PositionDiff diffTo(Coordinate destination) {
        return new PositionDiff(row.diff(destination.row), column.diff(destination.column));
    }

    public Piece.Figure assignEmptyMark() {
        if ((row.getPosition() + column.getPosition()) % 2 == 0) {
            return Piece.Figure.getEmptyWhite();
        }
        return Piece.Figure.getEmptyBlack();
    }

    public static class PositionDiff {

        private int rowDiff;
        private int colDiff;

        public PositionDiff(int rowDiff, int colDiff) {
            this.rowDiff = rowDiff;
            this.colDiff = colDiff;
        }

        public int getRowDiff() {
            return rowDiff;
        }

        public int getColDiff() {
            return colDiff;
        }

        public boolean movingLengthCheck(UnitInfo unitInfo) {
            return unitInfo.eachMovingLengthCheck(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(row, that.row) &&
                Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "(" + row.getPosition() +", " + (char) column.getPosition() + ")";
    }
}
