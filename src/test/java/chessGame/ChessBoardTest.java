package chessGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pieces.Player;
import pieces.UnitImpl;
import pieces.coordinate.Coordinate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static pieces.Piece.*;
import static pieces.Piece.KING;
import static pieces.Piece.PAWN;

public class ChessBoardTest {

    public ChessBoard chessBoard;

    @Before
    public void setup() {
        chessBoard = ChessBoard.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        chessBoard.clear();
    }

    @Test
    public void initPositionTest_black() {

        assertThat(chessBoard.pickUnitAt(8, 'a').getPiece(), is(ROOK));
        assertThat(chessBoard.pickUnitAt(8, 'b').getPiece(), is(KNIGHT));
        assertThat(chessBoard.pickUnitAt(8, 'c').getPiece(), is(BISHOP));
        assertThat(chessBoard.pickUnitAt(8, 'd').getPiece(), is(QUEEN));
        assertThat(chessBoard.pickUnitAt(8, 'e').getPiece(), is(KING));
        assertThat(chessBoard.pickUnitAt(8, 'f').getPiece(), is(BISHOP));
        assertThat(chessBoard.pickUnitAt(8, 'g').getPiece(), is(KNIGHT));
        assertThat(chessBoard.pickUnitAt(8, 'h').getPiece(), is(ROOK));

        assertThat(chessBoard.pickUnitAt(7, 'a').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'b').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'c').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'd').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'e').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'f').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'g').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(7, 'h').getPiece(), is(PAWN));
    }

    @Test
    public void initPositionTest_white() {

        assertThat(chessBoard.pickUnitAt(1, 'a').getPiece(), is(ROOK));
        assertThat(chessBoard.pickUnitAt(1, 'b').getPiece(), is(KNIGHT));
        assertThat(chessBoard.pickUnitAt(1, 'c').getPiece(), is(BISHOP));
        assertThat(chessBoard.pickUnitAt(1, 'd').getPiece(), is(QUEEN));
        assertThat(chessBoard.pickUnitAt(1, 'e').getPiece(), is(KING));
        assertThat(chessBoard.pickUnitAt(1, 'f').getPiece(), is(BISHOP));
        assertThat(chessBoard.pickUnitAt(1, 'g').getPiece(), is(KNIGHT));
        assertThat(chessBoard.pickUnitAt(1, 'h').getPiece(), is(ROOK));

        assertThat(chessBoard.pickUnitAt(2, 'a').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'b').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'c').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'd').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'e').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'f').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'g').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(2, 'h').getPiece(), is(PAWN));
    }

    @Test
    public void attackCheck() {
        chessBoard.clear();

        chessBoard.addUnit(new UnitImpl(PAWN, Player.BLACK, new Coordinate(4, 'c')));
        chessBoard.addUnit(new UnitImpl(PAWN, Player.WHITE, new Coordinate(3, 'd')));

        assertThat(chessBoard.pickUnitAt(4, 'c').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(4, 'c').getUnitInfo().getPlayer(), is(Player.BLACK));
        assertThat(chessBoard.pickUnitAt(3, 'd').getPiece(), is(PAWN));
        assertThat(chessBoard.pickUnitAt(3, 'd').getUnitInfo().getPlayer(), is(Player.WHITE));

        chessBoard.pickUnitAt(3, 'd').moveTo(4, 'c');
        assertThat(chessBoard.pickDeadUnitAt(4, 'c').getPiece(), is(PAWN));
    }

    @Test
    public void movePawn_first_success_1() {
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e');
        assertThat(chessBoard.pickUnitAt(5, 'e').getPiece(), is(PAWN));
    }

    @Test
    public void movePawn_first_success_2() {
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e');
        chessBoard.pickUnitAt(5, 'e').moveTo(4, 'e');
        assertThat(chessBoard.pickUnitAt(4, 'e').getPiece(), is(PAWN));
    }

    @Test
    public void movePawn_first_success_3() {
        chessBoard.pickUnitAt(2, 'e').moveTo(4, 'e');
        assertThat(chessBoard.pickUnitAt(4, 'e').getPiece(), is(PAWN));
    }

    @Test
    public void movePawn_first_success_4() {
        chessBoard.pickUnitAt(7, 'e').moveTo(6, 'e');
        assertThat(chessBoard.pickUnitAt(6, 'e').getPiece(), is(PAWN));
    }

    @Test(expected = RuntimeException.class)
    public void movePawn_first_fail_2() {
        chessBoard.pickUnitAt(7, 'e').moveTo(7, 'd');
    }

    @Test(expected = RuntimeException.class)
    public void movePawn_first_fail_3() {
        chessBoard.pickUnitAt(7, 'e').moveTo(6, 'd');
    }

    @Test
    public void moveKing() {
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e'); // pawn
        chessBoard.pickUnitAt(8, 'e').moveTo(7, 'e'); // king
        assertThat(chessBoard.pickUnitAt(7, 'e').getPiece(), is(KING));
    }

    @Test(expected = RuntimeException.class)
    public void moveKing_fail_1() {
        chessBoard.pickUnitAt(8, 'e').moveTo(7, 'e'); // king
    }

    @Test(expected = RuntimeException.class)
    public void moveKing_fail_2() {
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e'); // pawn
        chessBoard.pickUnitAt(8, 'e').moveTo(6, 'e'); // king
    }
    
}
