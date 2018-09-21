package pieces.unitInfo;

import org.junit.Test;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BishopInfoTest {

    @Test
    public void directionConditionCheck() {
        BishopInfo bishopInfo = new BishopInfo(Piece.BISHOP, Player.BLACK, new Coordinate(1, 'a'));
        assertThat(bishopInfo.directionConditionCheck(new Coordinate(4, 'd')), is(bishopInfo));
    }

    @Test(expected = RuntimeException.class)
    public void directionConditionCheck_fail() {
        BishopInfo bishopInfo = new BishopInfo(Piece.BISHOP, Player.BLACK, new Coordinate(1, 'b'));
        bishopInfo.directionConditionCheck(new Coordinate(4, 'd'));
    }
}
