import org.junit.Test;
import chessGame.ChessBoard;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static pieces.Piece.*;

public class UnitTest {

    @Test
    public void initPositionTest_black() {

        ChessBoard chessBoard = ChessBoard.getInstance();

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

        ChessBoard chessBoard = ChessBoard.getInstance();

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
    public void movePawn_first() {
        ChessBoard chessBoard = ChessBoard.getInstance();
        chessBoard.initBlack();
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e');
        assertThat(chessBoard.pickUnitAt(5, 'e').getPiece(), is(PAWN));
    }
}
