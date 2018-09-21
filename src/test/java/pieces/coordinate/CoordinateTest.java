package pieces.coordinate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoordinateTest {

    @Test
    public void makeDiagonal() {
        // given
        Coordinate presentPosition = new Coordinate(1, 'a');
        Coordinate destination = new Coordinate(4, 'd');

        // when
        List<Coordinate> result = Coordinate.makeStepsDiagonal(new ArrayList<>(), presentPosition, destination);

        // then
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(2, 'b'),
                new Coordinate(3, 'c'),
                new Coordinate(4, 'd'));
        assertThat(result, is(expected));
    }

    @Test
    public void makeOthogonal_1() {
        // given
        Coordinate presentPosition = new Coordinate(1, 'a');
        Coordinate destination = new Coordinate(4, 'a');

        // when
        List<Coordinate> result = Coordinate.makeStepsOthogonal(new ArrayList<>(), presentPosition, destination);

        // then
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(2, 'a'),
                new Coordinate(3, 'a'),
                new Coordinate(4, 'a'));
        assertThat(result, is(expected));
    }

    @Test
    public void makeOthogonal_2() {
        // given
        Coordinate presentPosition = new Coordinate(8, 'a');
        Coordinate destination = new Coordinate(6, 'a');

        // when
        List<Coordinate> result = Coordinate.makeStepsOthogonal(new ArrayList<>(), presentPosition, destination);

        // then
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(7, 'a'),
                new Coordinate(6, 'a'));
        assertThat(result, is(expected));
    }

    @Test
    public void makeOthogonal_3() {
        // given
        Coordinate presentPosition = new Coordinate(8, 'a');
        Coordinate destination = new Coordinate(8, 'd');

        // when
        List<Coordinate> result = Coordinate.makeStepsOthogonal(new ArrayList<>(), presentPosition, destination);

        // then
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(8, 'b'),
                new Coordinate(8, 'c'),
                new Coordinate(8, 'd'));
        assertThat(result, is(expected));
    }
}
