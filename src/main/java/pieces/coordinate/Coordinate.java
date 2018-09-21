package pieces.coordinate;

import pieces.Piece;
import pieces.Player;
import pieces.unitInfo.PawnInfo;
import pieces.unitInfo.UnitInfo;

import java.util.List;
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

    public static List<Coordinate> makeStepsDiagonal(List<Coordinate> coordinates, Coordinate presentPosition, Coordinate destination) {
        PositionDiff positionDiff = presentPosition.diffTo(destination);
        Coordinate nextPosition;
        if (presentPosition.equals(destination)) {
            return coordinates;
        }
        nextPosition = new Coordinate(presentPosition.row.getPosition()+positionDiff.oneRowStep(), presentPosition.column.getPosition()+positionDiff.oneColStep());
        coordinates.add(nextPosition);
        return makeStepsDiagonal(coordinates, nextPosition, destination);
    }

    public static List<Coordinate> makeStepsOthogonal(List<Coordinate> coordinates, Coordinate presentPosition, Coordinate destination) {
        PositionDiff positionDiff = presentPosition.diffTo(destination);
        Coordinate nextPosition = null;
        if (presentPosition.equals(destination)) {
            return coordinates;
        }
        if (positionDiff.colDiff == 0) {
            nextPosition = new Coordinate(presentPosition.row.getPosition()+positionDiff.oneRowStep(), presentPosition.column.getPosition());
        }
        if (positionDiff.rowDiff == 0) {
            nextPosition = new Coordinate(presentPosition.row.getPosition(), presentPosition.column.getPosition() + positionDiff.oneColStep());
        }
        coordinates.add(nextPosition);
        return makeStepsOthogonal(coordinates, nextPosition, destination);
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

        public boolean isDiagonal() {
            return Math.abs(rowDiff) == Math.abs(colDiff);
        }

        public boolean isOthogonal() {
            return rowDiff == 0 || colDiff == 0;
        }

        public int oneRowStep() {
            return rowDiff < 0 ? 1 : -1;
        }

        public int oneColStep() {
            return colDiff < 0 ? 1 : -1;
        }

        public boolean isLength(double n) {
            return Math.sqrt(Math.pow(rowDiff, 2) + Math.pow(colDiff, 2)) == n;
        }

        @Override
        public String toString() {
            return String.format("row diff : %d, col diff : %d", rowDiff, colDiff);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PositionDiff that = (PositionDiff) o;
            return rowDiff == that.rowDiff &&
                    colDiff == that.colDiff;
        }

        @Override
        public int hashCode() {

            return Objects.hash(rowDiff, colDiff);
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

    public int getRow() {
        return row.getPosition();
    }

    public int getColumn() {
        return column.getPosition();
    }
}
