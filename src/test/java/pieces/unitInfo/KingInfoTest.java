package pieces.unitInfo;

import org.junit.Test;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KingInfoTest {

    @Test
    public void directionConditionCheck() {
        KingInfo kingInfo = new KingInfo(Piece.KING, Player.BLACK, new Coordinate(2, 'd'));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(1, 'c')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(1, 'd')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(1, 'e')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(2, 'c')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(1, 'e')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(3, 'c')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(3, 'd')), is(kingInfo));
        assertThat(kingInfo.directionConditionCheck(new Coordinate(3, 'e')), is(kingInfo));
    }

    @Test(expected = RuntimeException.class)
    public void directionConditionCheck_fail() {
        KingInfo kingInfo = new KingInfo(Piece.KING, Player.BLACK, new Coordinate(2, 'd'));
        kingInfo.directionConditionCheck(new Coordinate(4, 'c'));
    }

}
