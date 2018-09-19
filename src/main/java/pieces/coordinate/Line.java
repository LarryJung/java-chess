package pieces.coordinate;

import java.util.Objects;

public class Line {

    private int position;

    Line(int position) {
        this.position = position;
    }

    public int diff(Line target) {
        return position - target.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return position == line.position;
    }

    @Override
    public int hashCode() {

        return Objects.hash(position);
    }

}
