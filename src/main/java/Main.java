import chessGame.ChessBoard;
import pieces.Player;
import pieces.coordinate.Coordinate;
import view.BoardView;
import view.Input;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ChessBoard chessBoard = ChessBoard.getInstance();
        BoardView boardView = new BoardView();
        Input input = new Input();
        System.out.print("\033[H\033[2J");
        System.out.println("체스 게임 시작합니다.");
        Thread.sleep(1500);
        System.out.println("White 부터 시작합니다.");
        Thread.sleep(1500);
        while(true) {
            wholeAction(chessBoard, boardView, input, Player.WHITE);
            wholeAction(chessBoard, boardView, input, Player.BLACK);
        }
    }

    private static void wholeAction(ChessBoard chessBoard, BoardView boardView, Input input, Player player) throws IOException, InterruptedException {
        try {
            action(chessBoard, boardView, input, player);
            if (chessBoard.isGameEnd()) {
                System.exit(0);
            }
        } catch (RuntimeException e) {
            wholeAction(chessBoard, boardView, input, player);
        }
    }

    private static void action(ChessBoard chessBoard, BoardView boardView, Input input, Player player) throws IOException, InterruptedException {
        System.out.print("\033[H\033[2J");
        boardView.drawBoard();
        System.out.println("현재 플레이어 : " + player);
        System.out.println("움직일 말을 선택해 주세요.");
        Coordinate unitPosition = input.takePosition();
        System.out.println("목적지 선택해 주세요.");
        Coordinate destination = input.takePosition();
        chessBoard.pickUnitAt(unitPosition).moveTo(destination);
        chessBoard.isCheckMate();
        Thread.sleep(500);
    }

}
