import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static pieces.Piece.*;

public class UnitTest {

    @Test
    public void initPositionTest_black() {

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initBlack();

        assertThat(chessBoard.atPosition(8, 'a').getPiece(), is(ROOK));
        assertThat(chessBoard.atPosition(8, 'b').getPiece(), is(KNIGHT));
        assertThat(chessBoard.atPosition(8, 'c').getPiece(), is(BISHOP));
        assertThat(chessBoard.atPosition(8, 'd').getPiece(), is(QUEEN));
        assertThat(chessBoard.atPosition(8, 'e').getPiece(), is(KING));
        assertThat(chessBoard.atPosition(8, 'f').getPiece(), is(BISHOP));
        assertThat(chessBoard.atPosition(8, 'g').getPiece(), is(KNIGHT));
        assertThat(chessBoard.atPosition(8, 'h').getPiece(), is(ROOK));

        assertThat(chessBoard.atPosition(7, 'a').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'b').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'c').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'd').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'e').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'f').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'g').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(7, 'h').getPiece(), is(PAWN));
    }

    @Test
    public void initPositionTest_white() {

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initWhite();

        assertThat(chessBoard.atPosition(1, 'a').getPiece(), is(ROOK));
        assertThat(chessBoard.atPosition(1, 'b').getPiece(), is(KNIGHT));
        assertThat(chessBoard.atPosition(1, 'c').getPiece(), is(BISHOP));
        assertThat(chessBoard.atPosition(1, 'd').getPiece(), is(QUEEN));
        assertThat(chessBoard.atPosition(1, 'e').getPiece(), is(KING));
        assertThat(chessBoard.atPosition(1, 'f').getPiece(), is(BISHOP));
        assertThat(chessBoard.atPosition(1, 'g').getPiece(), is(KNIGHT));
        assertThat(chessBoard.atPosition(1, 'h').getPiece(), is(ROOK));

        assertThat(chessBoard.atPosition(2, 'a').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'b').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'c').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'd').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'e').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'f').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'g').getPiece(), is(PAWN));
        assertThat(chessBoard.atPosition(2, 'h').getPiece(), is(PAWN));
    }

}
