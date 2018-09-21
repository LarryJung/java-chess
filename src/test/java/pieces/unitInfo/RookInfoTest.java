package pieces.unitInfo;

import org.junit.Test;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RookInfoTest {

    @Test(expected = RuntimeException.class)
    public void directionConditionCheck_fail() {
        RookInfo rookInfo = new RookInfo(Piece.ROOK, Player.BLACK, new Coordinate(1, 'a'));
        rookInfo.directionConditionCheck(new Coordinate(2, 'b'));
    }

    @Test(expected = RuntimeException.class)
    public void directionConditionCheck_fail_2() {
        RookInfo rookInfo = new RookInfo(Piece.ROOK, Player.BLACK, new Coordinate(1, 'a'));
        rookInfo.directionConditionCheck(new Coordinate(2, 'c'));
    }

    @Test
    public void directionConditionCheck_1() {
        RookInfo rookInfo = new RookInfo(Piece.ROOK, Player.BLACK, new Coordinate(1, 'a'));
        assertThat(rookInfo.directionConditionCheck(new Coordinate(1, 'f')), is(rookInfo));
    }
}
