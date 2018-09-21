package pieces.unitInfo;

import chessGame.ChessBoard;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PawnInfoTest {

    @Mock
    ChessBoard chessBoard;

    @InjectMocks
    PawnInfo pawnInfo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void directionConditionCheck_1() {
//        pawnInfo = new PawnInfo(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e'));
//        Coordinate destination = new Coordinate(3, 'f');
//        when(chessBoard.isEnemy(any(), any())).thenReturn(true); // is not working.
//        assertThat(pawnInfo.directionConditionCheck(destination), is(pawnInfo));
//    }


    @Test
    public void directionConditionCheck_2() {
        pawnInfo = new PawnInfo(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e'));
        Coordinate destination = new Coordinate(4, 'e');
        assertThat(pawnInfo.directionConditionCheck(destination), is(pawnInfo));
    }

    @Test
    public void directionConditionCheck_3() {
        pawnInfo = new PawnInfo(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e'));
        Coordinate destination = new Coordinate(3, 'e');
        assertThat(pawnInfo.directionConditionCheck(destination), is(pawnInfo));
    }

    @Test(expected = RuntimeException.class)
    public void directionConditionCheck_4() {
        pawnInfo = new PawnInfo(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e'), 2);
        Coordinate destination = new Coordinate(4, 'e');
        pawnInfo.directionConditionCheck(destination);
    }

    @Test
    public void directionConditionCheck_5() {
        pawnInfo = new PawnInfo(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e'), 2);
        Coordinate destination = new Coordinate(3, 'e');
        assertThat(pawnInfo.directionConditionCheck(destination), is(pawnInfo));
    }
}
