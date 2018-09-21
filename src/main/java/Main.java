import chessGame.ChessBoard;
import pieces.coordinate.Coordinate;
import view.BoardView;
import view.Input;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ChessBoard chessBoard = ChessBoard.getInstance();
        BoardView boardView = new BoardView();
        Input input = new Input();

        System.out.println("체크 게임 시작합니다.");
        System.out.println("White 부터 시작합니다.");

        while(!chessBoard.isGameEnd()) {
            System.out.println(">> BLACK PLAYER");
            wholeAction(chessBoard, boardView, input);
            System.out.println(">> WHITE PLAYER");
            wholeAction(chessBoard, boardView, input);
        }
    }

    private static void wholeAction(ChessBoard chessBoard, BoardView boardView, Input input) throws IOException {
        try {
            action(chessBoard, boardView, input);
        } catch (RuntimeException e) {
            action(chessBoard, boardView, input);
        }
    }

    private static void action(ChessBoard chessBoard, BoardView boardView, Input input) throws IOException {
        boardView.drawBoard();
        System.out.println("움직일 말을 선택해 주세요.");
        Coordinate unitPosition = input.takePosition();
        System.out.println("목적지 선택해 주세요.");
        Coordinate destination = input.takePosition();
        chessBoard.pickUnitAt(unitPosition).moveTo(destination);
    }

}
