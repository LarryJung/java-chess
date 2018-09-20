import chessGame.ChessBoard;
import view.BoardView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ChessBoard chessBoard = ChessBoard.getInstance();
        BoardView boardView = new BoardView();
        boardView.drawBoard();
        Thread.sleep(500);
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e');
        Thread.sleep(500);
        boardView.drawBoard();
    }

}
