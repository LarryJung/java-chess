import chessGame.ChessBoard;
import view.BoardView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ChessBoard chessBoard = ChessBoard.getInstance();
        BoardView boardView = new BoardView();
        boardView.drawBoard();
        Thread.sleep(1000);
        chessBoard.pickUnitAt(7, 'e').moveTo(5, 'e');
        Thread.sleep(1000);
        boardView.drawBoard();
        chessBoard.pickUnitAt(7, 'f').moveTo(5, 'f');
        Thread.sleep(1000);
        boardView.drawBoard();
        chessBoard.pickUnitAt(8, 'e').moveTo(7, 'e');
        Thread.sleep(1000);
        boardView.drawBoard();
        chessBoard.pickUnitAt(2, 'e').moveTo(4, 'e');
        Thread.sleep(1000);
        boardView.drawBoard();
        chessBoard.pickUnitAt(8, 'b').moveTo(6, 'a');
        Thread.sleep(1000);
        boardView.drawBoard();
        chessBoard.pickUnitAt(2, 'a').moveTo(4, 'a');
        Thread.sleep(1000);
        boardView.drawBoard();
    }

}
