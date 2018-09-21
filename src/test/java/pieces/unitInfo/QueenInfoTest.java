package pieces.unitInfo;

import org.junit.Test;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueenInfoTest {

    @Test(expected = RuntimeException.class)
    public void directionConditionCheck() {
        QueenInfo queenInfo = new QueenInfo(Piece.QUEEN, Player.BLACK, new Coordinate(1, 'a'));
        queenInfo.directionConditionCheck(new Coordinate(2, 'c'));
    }



}
