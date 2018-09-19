package pieces.coordinate;

import java.util.Objects;

public class Coordinate {

    private Line row;
    private Line column;

    public Coordinate(int row, char col) {
        this.row = new Line(row);
        this.column = new Line(col);
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
}
