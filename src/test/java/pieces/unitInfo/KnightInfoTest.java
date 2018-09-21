package pieces.unitInfo;

import org.junit.Test;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KnightInfoTest {

    @Test
    public void directionConditionCheck() {
        KnightInfo knightInfo = new KnightInfo(Piece.KNIGHT, Player.BLACK, new Coordinate(3, 'd'));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(1, 'c')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(1, 'e')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(2, 'b')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(4, 'b')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(2, 'f')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(4, 'f')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(5, 'c')), is(knightInfo));
        assertThat(knightInfo.directionConditionCheck(new Coordinate(5, 'e')), is(knightInfo));
    }

}
