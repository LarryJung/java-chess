import chessGame.ChessBoard;
import view.BoardView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ChessBoard chessBoard = ChessBoard.getInstance();
        BoardView boardView = new BoardView();
        boardView.drawBoard();
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e');
        boardView.drawBoard();
    }

}
