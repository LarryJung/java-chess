package pieces.coordinate;

import pieces.Piece;
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

    public List<Coordinate> makeStepsDiagonal(List<Coordinate> coordinates, Coordinate destination) {
        PositionDiff positionDiff = this.diffTo(destination);
        if (this.equals(destination)) {
            return coordinates;
        }
        coordinates.add(new Coordinate(row.getPosition()+positionDiff.oneRowStep(), column.getPosition()+positionDiff.oneColStep()));
        return makeStepsDiagonal(coordinates, destination);
    }

    public List<Coordinate> makeStepsOthogonal(List<Coordinate> coordinates, Coordinate destination) {
        PositionDiff positionDiff = this.diffTo(destination);
        if (this.equals(destination)) {
            return coordinates;
        }
        if (positionDiff.colDiff == 0) {
            coordinates.add(new Coordinate(row.getPosition()+positionDiff.oneRowStep(), column.getPosition()));
        }
        if (positionDiff.rowDiff == 0) {
            coordinates.add(new Coordinate(row.getPosition(), column.getPosition() + positionDiff.oneColStep()));
        }
        return makeStepsOthogonal(coordinates, destination);
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
            return rowDiff < 0 ? -1 : 1;
        }

        public int oneColStep() {
            return colDiff < 0 ? -1 : 1;
        }

        public boolean isLength(double n) {
            return Math.sqrt(Math.pow(rowDiff, 2) + Math.pow(colDiff, 2)) == n;
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
